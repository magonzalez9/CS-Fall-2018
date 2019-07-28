import React, { Component } from 'react'

const ListItems = (props) => {
    const {children} = props; 
    return (
        <ul className="list-group">
            {children}
        </ul>
    );
}

export default ListItems;
