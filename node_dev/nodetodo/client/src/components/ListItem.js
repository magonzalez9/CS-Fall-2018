import React, { Component } from 'react'

const ListItem = (props) =>{
    const {title, isDone} = props; 
    return (
        <li className="list-group-item">
            {isDone ? (<span class="glyphicon glyphicon-ok"></span>) : (<span class="glyphicon glyphicon-remove"></span>)} {' '}
            <b>{title}</b>
        </li>
    )
}

export default ListItem;
