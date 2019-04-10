var canvas = document.getElementById("canvas");

image = new MarvinImage();
image.load("imgs/8.jpg", imageLoaded);

function imageLoaded(){
  var imageOut = new MarvinImage(image.getWidth(), image.getHeight());
  
  // Edge Detection (Prewitt approach)
  Marvin.prewitt(image, imageOut);
  // Invert color
  Marvin.invertColors(imageOut, imageOut);
  // Threshold
  Marvin.thresholding(imageOut, imageOut, 220);
  imageOut.draw(canvas); 
}