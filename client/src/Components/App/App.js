
import './App.css';
import React from 'react';
import Search from '../Search/Search';
import { render } from 'react-dom';
import CSPartsList from '../ComputerPartsList/CSPartsList';
import Nav from '../Header/Nav.js';
const computerParts = {
  imgSrc : "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.anandtech.com%2Fshow%2F14814%2Fbest-motherboards-q1-2019&psig=AOvVaw0nFT5e9iJLTZSI1NHzvj3t&ust=1633126030478000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNia-Nnap_MCFQAAAAAdAAAAABAM",
  name: 'MOTHERBOARDS'
}
const computerPartsArray = [
  computerParts,
  computerParts,
  computerParts,
  computerParts,
  computerParts,
  computerParts
]
class App extends React.Component {
  render(){
    return (
      <div className = "App"> 
        <Nav/>
       
        <CSPartsList ComputerPartsArray={computerPartsArray} />
       </div> 
    );
   
  }
  
  
}

export default App;
