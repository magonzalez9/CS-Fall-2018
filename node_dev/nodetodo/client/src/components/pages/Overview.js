import React, { Component } from 'react'
import ItemsBody from '../ItemsBody'; 
import MainLayout from '../MainLayout'; 

export class Overview extends Component {
    render() {
        return (
            <div>
                <h1>Dashboard</h1>
                <br />
                <div className="container">
                    <ItemsBody/>                 
                </div>
            </div>


        )
    }
}

export default Overview;
