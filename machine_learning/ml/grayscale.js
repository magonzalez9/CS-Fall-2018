function getImagePixels()  {
	// Create canvas and get image
    var c = document.createElement("canvas");
	var ctx = c.getContext("2d");
    var img = document.getElementById("image");

    // Set canvas dimensions proportional to image dimensions
    c.width = img.width; 
    c.height = img.height; 

    // Draw image onto the canvas and get image data
    ctx.drawImage(img, 0, 0);
    var imgData = ctx.getImageData(0, 0, c.width, c.height);


    // Loop through every pixel in order to determine its color
    var pixelArray = new Array(); 
    var j = 0; 
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

	if (sumAvg >=.7) {
		return "*";
	} else if (sumAvg < .7){
		return "-"; 
	}
} // --end of function getGrayScaleValue

function debug(){
	pixelArray = getImagePixels(); 

	var cleanStr = ""; 
	var multiplier = 1; 
	for (var i = 0; i < pixelArray.length; i++) {
		cleanStr += pixelArray[i] + "";

		if (i == (multiplier * 349)) {
			cleanStr += "<br />"; 
			multiplier++; 
		}
	}

	document.getElementById("pixels").innerHTML = cleanStr;
}
