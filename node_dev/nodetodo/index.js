const express = require('express');
const apiRoute = require('./routes/api'); 
const bodyParser = require('body-parser'); 
const app = express(); 

// Use Body Parser
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

// Executes api (could be anything e.g '/random')
app.use('/api', apiRoute);

app.listen('8000'); 