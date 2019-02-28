
<!DOCTYPE html>
<html>
<head>
	<title>Face Detection Application</title>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"/> -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="face_detection/dist/jquery.facedetection.min.js"> </script>
	<script src="photo_approval.js"></script>
	<style>
		.face-box {
  		border: 1px solid #f00;
  		position:absolute;
		}
	</style>
</head>
<body>
<h1>Photo Detection Application</h1>
<div id="wrapper"></div>
<img id="picture" src="original_photos/color/1.jpg">
<br />
<button onclick="getNextPhoto(false)">Prev</button>
<button onclick="getNextPhoto(true)">Next</button>
<br />
<br />
<fieldset>
<!--Image setings-->
Interval: <input type="number" id="interval" name="interval" min="1" max="100" value="4"> <br/> <br/>
minNeighbors: <input type="number" id="minNeighbors" name="minNeighbors" min="1" max="100" value="1"><br /><br />
Confidence: <input type="number" id="confidence" name="confidence" min="1" max="100" value=""><br/><br/>

<br />
<label>Grayscale</label><br />
<input type="radio" name="grayscale" id="grayscale" value="true"> True<br>
<input type="radio" name="grayscale" id="grayscale" value="false" checked="checked"> False<br>
<br>
<button onclick="analyzeImage()">Analyze</button>
<!-- <button onclick="debug()">Analyze</button> -->
<p id="pixels"> </p>



<p id="response"></p>
</fieldset>

</body>
</html>


