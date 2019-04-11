var canvas = document.getElementById("canvas");
canvas.width = 275; 
canvas.height = 275; 

image = new MarvinImage();
image.load("imgs/3.jpg", imageLoaded);

function imageLoaded(){
  var imageOut = new MarvinImage(image.getWidth(), image.getHeight());
  // canvas.width = image.getWidth; 
  // canvas.height = image.getHeight; 
  // Edge Detection (Prewitt approach)
  Marvin.prewitt(image, imageOut);
  // Invert color
  Marvin.invertColors(imageOut, imageOut);
  // Threshold
  Marvin.thresholding(imageOut, imageOut, 220);
  imageOut.draw(canvas); 
}