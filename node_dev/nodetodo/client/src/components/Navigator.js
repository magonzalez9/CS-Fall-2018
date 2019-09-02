import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import NavDropdown from 'react-bootstrap/NavDropdown'; 
import {Router, Link} from '@reach/router'; 
import styled from 'styled-components';
import Dashboard from './pages/Overview'; 
import About from './pages/About'; 
import AddTodoForm from './pages/AddTodoForm'; 
import ModifyTodo from './pages/ModifyTodo'; 
import Contact from './pages/Contact'; 

export class Navigator extends Component {
    constructor(props){
        super(props); 

        this.state = {

        }
    }

    render() {
        return (
            <Root>
                <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                    <NavBrand>TodosJS</NavBrand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="mr-auto">
                        <NavLink to="/" getProps={isActive}>Dashboard</NavLink>
                        <NavLink to="/about/" getProps={isActive}>About</NavLink>
                        <NavDropdown title="Actions" id="collasible-nav-dropdown">
                            <DropDownContainer>
                            <DropLink to="/add/" getProps={dropIsActive}>Add</DropLink>
                            <DropLink to="/modify/" getProps={dropIsActive}>Modify</DropLink>
                            <NavDropdown.Divider />
                            <DropLink to="/contact/" getProps={dropIsActive}>Contact</DropLink>
                            </DropDownContainer>
                        </NavDropdown>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search Todos" className="mr-sm-2" />
                            <SearchButton variant="outline-info">Search</SearchButton>
                        </Form>
                    </Navbar.Collapse>
                </Navbar>

                <Router>
                    <Dashboard path="/"/>
                    <About path="/about/"/>
                    <AddTodoForm path="/add/"/>
                    <ModifyTodo path="/modify/"/>
                    <Contact path="/contact/" />
                </Router> 
            </Root>
        )
    }
}

const isActive = ({isCurrent}) => {
    return {
        style: {
          color: isCurrent ? "white" : "#999999"
        }
      };
}

const dropIsActive = ({isCurrent}) => {
    return {
        style: {
            background: isCurrent ? "#007bff" : "",
            color: isCurrent ? "white" : ""
        }
    }
}

export default Navigator;

const SearchButton = styled(Button)`

`;

const NavLink = styled(Link)`
    font-size: 17px; 
    padding-top: 8px; 
    padding-right: 10px; 
    padding-left: 5px; 
    
    :link{
        text-decoration: none; 
    }
    :hover{
        color: white; 
    }
`;

const NavBrand = styled(Navbar.Brand)`
    color: #17a2b8 !important; 
    font-weight: 500; 
`;
    

const Root = styled('div')`
    margin-bottom: 50px;
`;


const DropLink = styled(Link)`
    width: 200px;
    height: 30px;
    padding: 2px 0 5px 25px;

    :link{
        text-decoration: none;
    }
    :hover{
        background-color: #d7d9db; 
        color: white; 
    }


`;
const DropDownContainer = styled('div')`
    display: flex; 
    flex-direction: column;
`;
