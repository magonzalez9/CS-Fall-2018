var currentImg = 1; 

function getImagePixels()  {
	var img = document.getElementById("picture");
	// Create canvas and get image
    var c = document.createElement("canvas");
	var ctx = c.getContext("2d");

    // Set canvas dimensions proportional to image dimensions
    c.width = img.width; 
    c.height = img.height; 

    // Draw image onto the canvas and get image data
    ctx.drawImage(img, 0, 0);
    var imgData = ctx.getImageData(0, 0, c.width, c.height);


    // Loop through every pixel in order to determine its color
    var pixelArray = new Array(); 
    var j = 0; 

    // Multi dimensional array (x by x)
	for (var i = 0; i < imgData.data.length; i+=4) {
		pixelArray[j] = "("+imgData.data[i] +","+imgData.data[i+1]+","+imgData.data[i+2]+")";
		j++; 
  	}

    return pixelArray; 
} // --end of function getImagePixels



function debug(){
	var img = document.getElementById("picture");
	pixelArray = getImagePixels(); 

	var cleanStr = ""; 
	var multiplier = img.width; 
	for (var i = 0; i < pixelArray.length; i++) {
		cleanStr += pixelArray[i] + "";

		if (i == multiplier) {
			cleanStr += "|<br />"; 
			multiplier+=img.width; 
		}
	}

	document.getElementById("pixels").innerHTML = cleanStr;
}

function analyzeImage(){
	var img = document.getElementById("picture");
	// Get settings 
	var interval = parseInt(document.getElementById('interval').value, 10); 
	var minNeighbors = parseInt(document.getElementById('minNeighbors').value, 10);
	var confidence = parseInt(document.getElementById('confidence').value, 10); 
	var grayscale = document.querySelector('input[name="grayscale"]:checked').value;
	var imageData = ""; 

	if (grayscale == "false") {
		grayscale = false; 
	} else {
		grayscale = true; 
	}

	/* RETURN VALUES */
	// x — X coord of the face in the picture
	// y — Y coord of the face in the picture
	// width — Width of the face
	// height — Height of the face
	// positionX — X position relative to the document
	// positionY — Y position relative to the document
	// offsetX — X position relative to the offset parent
	// offsetY — Y position relative to the offset parent
	// scaleX — Ratio between original image width and displayed width
	// scaleY — Ratio between original image height and displayed height
	// confidence — Level of confidence position relative to the document

	// Get the face location
    $('#picture').faceDetection({
    	interval: interval,
    	minNeighbors: minNeighbors, 
    	confidence: null, 
    	async: false, 
    	grayscale: grayscale,
        complete: function (faces) {
        	// Get the count
        	console.log(faces.length); 
        	
        	if (faces.length > 0 ) {
        		// Output data for TESTING -------------------------------------------------------
        		imageData +=  "Image data (width: " + img.width + " | height:" + img.height + ")<br>";
        		imageData += "(x:" + faces[0].positionX + "y:" +  faces[0].positionY +")" + "<br>"+ "width: "+ faces[0].width + "height: "+ faces[0].height;
        		document.getElementById("data").innerHTML = imageData;
        		// Output data for TESTING -------------------------------------------------------

        		// Draw the BOX
			    $div = $("<div>", {"class": "face-box"});
			    $div.css('top', faces[0].positionY);
			    $div.css('left', faces[0].positionX );
			    $div.css('width', faces[0].width );
			    $div.css('height', faces[0].height );
			    $("#wrapper").append($div);
			    document.getElementById("response").innerHTML = "Confidence: " + faces[0].confidence;
        	} else {
        		console.log("NO FACES FOUND!"); 
        	}
     
        }

    });
}

function getNextPhoto(next){
	if (next == true) {
		currentImg++;
	} else {

		currentImg--; 
	}
	document.getElementById("wrapper").innerHTML = "";
	document.getElementById("picture").setAttribute("src", "original_photos/color/" + currentImg + ".jpg");
}

function getGrayScaleValue(r, g, b){
	// Apply affine transfomation to rgb values in order to color-categorize the pixels from 0-1
	// E.g. 0 (lighter pixel) - 1 (darker pixel) 
	// f(t)=(d−c)(b−a) / (t−a) + c
	var rValue = parseFloat(((r - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));
	var gValue = parseFloat(((g - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));
	var bValue = parseFloat(((b - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));

	var sumAvg = ((rValue + gValue + bValue) / 3).toFixed(2);

	// The lower the number the greater the darkness definition 
	var bwSensitivity = .5; 

	if (sumAvg >= bwSensitivity) {
		return "*";
	} else if (sumAvg < bwSensitivity){ 
		return "_"; 
	}
} // --end of function getGrayScaleValue