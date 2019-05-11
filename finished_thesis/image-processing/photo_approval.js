$(document).ready(function() {
    // document is loaded and DOM is ready
    setInterval(loadAnalyzingAnimation, 600);
});
function getImagePixels()  {
	var img = document.getElementById("picture");
	// Create canvas and get image
    var c = document.createElement("canvas");
	var ctx = c.getContext("2d");

    // Set canvas dimensions proportional to image dimensions
    c.width = img.naturalWidth; 
    c.height = img.naturalHeight; 

    // Draw image onto the canvas and get image data
    ctx.drawImage(img, 0, 0);
    var pixelArray = ctx.getImageData(0, 0, c.width, c.height).data;

    return pixelArray; 
} // --end of function filterImagePixels

function convertGrayscale(){
  var img = document.getElementById("picture");
  var myCanvas=document.getElementById("grayscaleCanvas");
  var ctx=myCanvas.getContext("2d");
  myCanvas.width = img.naturalWidth; 
  myCanvas.height = img.naturalHeight; 
  w = img.naturalWidth; 
  h = img.naturalHeight;

   ctx.drawImage(img, 0, 0, w, h);

      var imgPixels = ctx.getImageData(0, 0, w, h);
      for(var y = 0; y < imgPixels.height; y++){
       for(var x = 0; x < imgPixels.width; x++){
            var i = (y * 4) * imgPixels.width + x * 4;
            var avg = (imgPixels.data[i] + imgPixels.data[i + 1] + imgPixels.data[i + 2]) / 3;
            imgPixels.data[i] = avg;
            imgPixels.data[i + 1] = avg;
            imgPixels.data[i + 2] = avg;
       }
  }
	ctx.putImageData(imgPixels, 0, 0, 0, 0, imgPixels.width, imgPixels.height);

	// Get grayscale the image pixels 
	var grayscaleImgData = ctx.getImageData(0,0,myCanvas.width, myCanvas.height).data; 

	var grayScaleArray = []; 
	var p = 0; 

	for (var i = 0; i < img.naturalHeight; i++) {
		// Multi dimensional array (x by x)
		grayScaleArray[i] = new Array(img.naturalWidth);

		for (var j = 0; j < img.naturalWidth; j++) {
			grayScaleArray[i][j] = getGrayScaleValue(grayscaleImgData[p], grayscaleImgData[p+1], grayscaleImgData[p+2], .6);
			p+=4; 
	  	}
  	}
  	return grayScaleArray; 
}


function analyzeImage(interval){
	var img = document.getElementById("picture");

	// Settings -------------
	var pixelArray = getImagePixels(); 
	var grayScaleArray = convertGrayscale();

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
    	minNeighbors: 1, 
    	confidence: null, 
    	async: false, 
    	grayscale: false,
        complete: function (faces) {
        	

        	// Get the count
        	if (faces.length > 0 ) {
			    // Call the photo approval php 
			    $.ajax({  
				    type: 'post' ,  
				    url: 'image-processing/photo-approval-post.php', 
				    data: { faceWidth: faces[0].width,
				    		faceHeight: faces[0].height, 
				    		faceXPos: (faces[0].positionX+((faces[0].width)/2)) - img.offsetLeft, 
				    		faceYPos: (faces[0].positionY+((faces[0].height)/2)) - img.offsetTop, 
				    		imgWidth: img.naturalWidth,
				    		imgHeight: img.naturalHeight, 
				    		pixelArray: JSON.stringify(pixelArray),
				    		grayscaleArray: JSON.stringify(grayScaleArray),
				    		faceCount: faces.length
				    },
				    success: function(response) {
				        document.getElementById("feedback").innerHTML = response;
				    },
				    error : function(xhr, status, error)
				    {
				        alert("There was an error!" + error); 
				    }
				});
        	} else {
        		if (interval > 14) {
        			//output normal feedback
        			document.getElementById("feedback").innerHTML = document.getElementById("regular-feedback").innerHTML;
        			return false; 
        		} else {
        			// Increase interval
					analyzeImage(interval+=1);	
        		}
        		 
        	}
        }
    });

}

function validatePixelColors(imagePixelArray, imgHeight, imgWidth){
	// Loop through every pixel in order to determine its color
    var returnArray = new Array(imgHeight); 
    var p = 0; 

  	// Multi dimensional array (x by x)
	for (var i = 0; i < imgHeight; i++) {
		// Multi dimensional array (x by x)
		returnArray[i] = new Array(imgWidth);

		for (var j = 0; j < imgWidth; j++) {

			if (imagePixelArray.data[p] > 160 && imagePixelArray.data[p+1] > 155 && imagePixelArray.data[p+2] > 155) {
				returnArray[i][j] = 0; // white pixel
			} else {
				returnArray[i][j] = 1; // dark pixel
			}
			p+=4; 
	  	}
  	}

  	return returnArray;
}

function getGrayScaleValue(r, g, b, bwSensitivity){
	// Apply affine transfomation to rgb values in order to color-categorize the pixels from 0-1
	// E.g. 0 (lighter pixel) - 1 (darker pixel) 
	// f(t)=(d−c)(b−a) / (t−a) + c
	var rValue = parseFloat(((r - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));
	var gValue = parseFloat(((g - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));
	var bValue = parseFloat(((b - 255) * (1 - 0) / (0 - 255) + 0).toFixed(2));

	var sumAvg = ((rValue + gValue + bValue) / 3).toFixed(2);

	// The lower the bwSensitivity value the greater the darkness definition 
	if (sumAvg >= bwSensitivity) {
		return 1;
	} else if (sumAvg < bwSensitivity){ 
		return 0; 
	}
} // --end of function getGrayScaleValue

// Creates the loading '...' animation
function loadAnalyzingAnimation() {
    if(dots < 3) {
        $('#analyzingDots').append('.');
        dots++;
    }
    else {
        $('#analyzingDots').html('');
        dots = 0;
    }
}

