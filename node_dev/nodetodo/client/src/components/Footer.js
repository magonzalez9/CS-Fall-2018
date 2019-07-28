import React from 'react'; 
import styled from 'styled-components'; 

const Footer = () => {
    return (
        <Foot>
            TodoJS | Todo Inc.
        </Foot>
    )
}

export default Footer; 

const Foot = styled.footer`
  position:fixed;
  bottom: 0; 
  background-color: #343a40;
  padding: 10px;
  text-align: center;
  color: white;
  width: 100%; 
`;

