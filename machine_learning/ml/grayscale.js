var img = document.getElementById("image");

function getImagePixels()  {
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

    // Multi dimensional array
    


	for (var i = 0; i < imgData.data.length; i+=4) {
		pixelArray[j] = getGrayScaleValue(imgData.data[i], imgData.data[i+1], imgData.data[i+2]);
		j++; 
  	}

    return pixelArray; 
} // --end of function getImagePixels

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

function debug(){
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
