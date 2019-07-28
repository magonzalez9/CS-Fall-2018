const express = require('express'); 
const router = express.Router(); 
const todoRoute = require('./todo'); 

router.use('/todo', todoRoute);

module.exports = router; 

// localhost:3000/api/todo
// localhost:3000/api/users in the case of users
