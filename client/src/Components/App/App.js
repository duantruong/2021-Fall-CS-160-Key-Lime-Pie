
import './App.css';
import React from 'react';
import Search from '../Search/Search';
import { Switch,Route } from 'react-router';
import { render } from 'react-dom';

import Nav from '../Header/Nav.js';
import CSPartsList from '../ComputerPartsList/CSPartsList.js';
import Detail from '../Detail/Detail.js';
import Cart from '../Cart/Cart.js';
import Default from '../Default/Default.js';
import Login from '../Login/Login';
import CreateAcc from '../CreateAcc/CreateAcc';

import "bootstrap/dist/css/bootstrap.min.css";
class App extends React.Component {
  render(){
    return (
     <React.Fragment>
       
      <Nav/>
      <Switch>
        <Route exact path="/"component={CSPartsList}></Route>
        <Route path="/details"component={Detail}></Route>
        <Route path="/cart"component={Cart}></Route>
        <Route path="/login"component={Login}></Route>
        <Route path="/account-create"component={CreateAcc}></Route>
        <Route component={Default}></Route>
      </Switch>


     </React.Fragment>  
      );
   
  }
  
  
}
export default App;

