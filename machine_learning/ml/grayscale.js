function toGrayscale(image)
{
  var myCanvas=document.createElement("canvas");
  var myCanvasContext=myCanvas.getContext("2d");

  var imgWidth=image.width;
  var imgHeight=image.height;
  // You'll get some string error if you fail to specify the dimensions
  myCanvas.width = imgWidth;
  myCanvas.height = imgHeight;
   // alert(imgWidth);
  myCanvasContext.drawImage(image,0,0);

  // This function cannot be called if the image is not rom the same domain.
  // You'll get security error if you do.
  var imageData=myCanvasContext.getImageData(0,0, imgWidth, imgHeight);

  // This loop gets every pixels on the image and
    for (j=0; j<imageData.height; i++)
    {
      for (i=0; i<imageData.width; j++)
      {
         var index=(i*4)*imageData.width+(j*4);
         var red=imageData.data[index];
         var green=imageData.data[index+1];
         var blue=imageData.data[index+2];
         var alpha=imageData.data[index+3];
         var average=(red+green+blue)/3;
   	    imageData.data[index]=average;
         imageData.data[index+1]=average;
         imageData.data[index+2]=average;
         imageData.data[index+3]=alpha;
       }
     }

	return myCanvas.toDataURL();
  }

function change(image){
	image.src = toGrayscale(image);
}

function restore(){
	image.src = "original_photos/1.jpg";
}