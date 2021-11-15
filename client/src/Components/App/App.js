
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
import ListProduct from "../ListProduct";
import ComputerCases from "../ComputerCases";
import GraphicCards from "../GraphicCards";
import MotherBoards from "../MotherBoards";
import Processors from "../Processors";
import Coolings from "../Coolings";
import Storages from "../Storages";
import Peripherals from "../Peripherals";
import Monitors from "../Monitors";
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
        <Route path="/list-all-products"component={ListProduct}></Route>
        <Route path="/list-all-computer-cases"component={ComputerCases}></Route>
        <Route path="/list-all-graphics-cards"component={GraphicCards}></Route>
        <Route path="/list-all-motherboards"component={MotherBoards}></Route>
        <Route path="/list-all-processors"component={Processors}></Route>
        <Route path="/list-all-coolings"component={Coolings}></Route>
        <Route path="/list-all-storages"component={Storages}></Route>
        <Route path="/list-all-peripherals"component={Peripherals}></Route>
        <Route path="/list-all-monitors"component={Monitors}></Route>
        <Route path="/ListProduct/:id" component={Detail} exact></Route>
        <Route component={Default}></Route>


      </Switch>


     </React.Fragment>  
      );
   
  }
  
  
}
export default App;

