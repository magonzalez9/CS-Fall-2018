import React, { Component } from 'react'
import ListItems from './ListItems'; 
import ListItem from './ListItem'; 
import axios from 'axios'; 
import styled from 'styled-components'; 
import _ from 'lodash';

export class ItemsBody extends Component {
    constructor(props){
        super(props); 
        this.state = {
            loading:true,
            todos: {}
        };
    }

    componentDidMount(){
        axios.get('/api/todo').then(response => {
            this.setState({
                loading: false,
                todos: response.data
            });
        });

        // axios.post('/api/todo', {
        //     title: 'Testing',
        //     is_done: false,
        // }).then(() => {
        //     alert("Success!"); 
        // })
    }

    renderTodos(){
        return _.map(this.state.todos, todo=>{
            return(
                <ListItem title={todo.title} isDone={todo.is_done}/>
            )
        })
    }
    
    render() {
        if(this.state.loading == true){
            return (
                <h1>Loading...</h1>
            )
        }
        return (
            <ListItems>
                {this.renderTodos()}
            </ListItems>
                
        )
    }

    
}

export default ItemsBody
