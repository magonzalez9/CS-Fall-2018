function getImagePixels()  {
    var c = document.createElement("canvas");
	var ctx = c.getContext("2d");
    var img = document.getElementById("image");
    ctx.drawImage(img, 0, 0);
    var imgData = ctx.getImageData(0, 0, c.width, c.height);

    var str = ''; 
	for (var i = 0; i < imgData.data.length; i+=4) {
		// (r, g , b, alpha)
		// str += imgData.data[i] + "," + imgData.data[i+1] + "," + imgData.data[i+2] + " | ";
		str += rgbConvert(imgData.data[i], imgData.data[i+1], imgData.data[i+2]) + "|"; 
  	}

    document.getElementById("pixels").innerHTML = str;
}

function rgbConvert(r, g, b){
	// Use some 
	var rValue = ((r - 0) * (1 - 0) / (255 - 0) + 0);
	var gValue = ((g - 0) * (1 - 0) / (255 - 0) + 0);
	var bValue = ((b - 0) * (1 - 0) / (255 - 0) + 0);

	return rValue + ", " + gValue + ", " + bValue;

}