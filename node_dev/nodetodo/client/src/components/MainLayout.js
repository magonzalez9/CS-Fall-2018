import React, {Component} from 'react';
import styled from 'styled-components'; 
import Navigator from './Navigator'; 
import Footer from './Footer'; 

class MainLayout extends Component{
    constructor(props){
        super(props); 
    }
    render(){
        return (
            <Root>
                <Navigator/>
                <Footer/>
            </Root>
        )
    }
}

export default MainLayout;

const Root = styled.div`
    padding:0;
    margin:0;
    height:100%;
`;