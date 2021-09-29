
import './App.css';
import React from 'react';
import Search from '../Search/Search';
import { render } from 'react-dom';

class App extends React.Component {
  render(){
    return (
      <div className = "App"> 
        <h1>MICROEGG</h1>
        <Search/>
       </div> 
    );
   
  }
  
  
}

export default App;
