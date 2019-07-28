const express = require('express');
const router = express.Router(); 
const db = require('../../database'); 


// GET request
router.get('/', (req, res) => {
    db.select().from('todo').orderBy('id').then( data =>{
        res.send(data);
    });
})

// POST request
router.post('/', function(req, res){
    db.insert(req.body).returning('*').into('todo').then(data => {
        res.send(data);
    });
});

// PATCH request
router.patch('/:id', function(req, res){
    db('todo').where({id: req.params.id}).update(req.body).returning('*').then(function(data){
        res.send(data)
    });
});

// PUT request
router.put('/:id', function(req, res){
    db('todo').where({id: req.params.id}).update({
        title: req.body.title || null,
        is_done: req.body.is_done || null,
    }).returning('*').then(function(data){
        res.send(data)
    });
});

router.delete('/:id', function(req, res){
    db('todo').where({id: req.params.id}).del().then(function (){
        res.json({success: true});
    })
});

router.get('/:id', function(req, res){
    db('todo').where({id: req.params.id}).select().then(function(data){
        res.send(data); 
    });
});

module.exports = router;