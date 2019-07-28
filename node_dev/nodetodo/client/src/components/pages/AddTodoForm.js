import React, { Component } from 'react'
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col'; 
import Row from 'react-bootstrap/Row'; 
import Button from 'react-bootstrap/Button'; 
import styled from 'styled-components'; 

export class AddTodoForm extends Component {
    constructor(props){
        super(props); 
        this.state = {
            title: '', 
            dueDate: '',
            description: '', 
            priority: null,
        }
        this.onRadioChange = this.onRadioChange.bind(this); 
    }

    handleFormSubmit = () => {
        console.log(this.state); 
    }

    handleInputOnChange = (event) => {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value; 
        const name = target.name; 
        this.setState({[name]: value});
    }

    onRadioChange = function(){

    }

    render() {
        return (
            <Root className="container">
                <Title>Add Todo!</Title>
                <fieldset>
               <Form>
                    <Form.Group as={Row} controlId="formHorizontalEmail">
                        <Form.Label column sm={2}>
                        Title 
                        </Form.Label>
                        <Col sm={10}>
                        <Form.Control type="text" placeholder="Name" name="title" onChange={this.handleInputOnChange} />
                        </Col>
                    </Form.Group>

                    <Form.Group as={Row} controlId="formHorizontalPassword" >
                        <Form.Label column sm={2}>
                        Due Date
                        </Form.Label>
                        <Col sm={10}>
                        <Form.Control type="date" placeholder="Date" name="dueDate" onChange={this.handleInputOnChange} />
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} controlId="exampleForm.ControlTextarea1" >
                        <Form.Label column sm={2}>
                            Description
                        </Form.Label>
                        <Col sm={10}>
                        <Form.Control as="textarea" rows="5" name="description" onChange={this.handleInputOnChange} />
                        </Col>
                    </Form.Group>
                    <fieldset>
                        <Form.Group as={Row}>
                        <Form.Label as="legend" column sm={2}>
                            Priority:
                        </Form.Label>
                        <Col sm={10}>
                            <Form.Check inline
                            type="radio"
                            label="High"
                            name="priority"
                            value="3"
                            onChange={this.handleInputOnChange}
                            />
                            <Form.Check inline
                            type="radio"
                            label="Medium"
                            name="priority"
                            value="2"
                            onChange={this.handleInputOnChange}
                            />
                            <Form.Check inline
                            type="radio"
                            label="Low"
                            name="priority"
                            value="1"
                            onChange={this.handleInputOnChange}
                            />
                        </Col>
                        </Form.Group>
                    </fieldset>

                    <Form.Group as={Row}>
                        <Col sm={{ span: 10, offset: 2 }}>
                        <Button onClick={this.handleFormSubmit}>Add Todo</Button>
                        </Col>
                    </Form.Group>
                </Form>
                </fieldset>
            </Root>
        )
    }
}

export default AddTodoForm

const Root = styled.div`
    margin-top: 20px; 
`;

const Title = styled.h1`
    margin-bottom: 20px; 
`;
