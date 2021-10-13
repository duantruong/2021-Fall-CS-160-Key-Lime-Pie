import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, BrowserRouter as Router} from 'react-router-dom';
import App from './Components/App/App.js';
import './index.css';


ReactDOM.render(
  <Router>
    <App />
  </Router>
  

  ,
  document.getElementById('root')
);
