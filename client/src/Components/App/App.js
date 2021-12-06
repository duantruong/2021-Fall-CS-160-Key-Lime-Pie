
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
import  {useState} from 'react';


export default  function App(){
    const[cartItems,setCartItems] = useState([])
    const onAdd = (product) => {
      const exist = cartItems.find((x) =>x.productId === product.productId)
      if (exist){
        setCartItems(
            cartItems.map((x) =>
            x.productId === product.productId ? {...exist,qty:exist.qty + 1}: x
            )
        )
      } else {
        setCartItems([...cartItems,{...product,qty:1}])
      }
    }
    const onRemove = (product) => {
        const exist = cartItems.find((x) => x.productId === product.productId);
        if (exist.qty === 1) {
            setCartItems(cartItems.filter((x) => x.productId !== product.productId));
        } else {
            setCartItems(
                cartItems.map((x) =>
                    x.productId === product.productId ? { ...exist, qty: exist.qty - 1 } : x
                )
            );
        }
    };
    return (
     <React.Fragment>
       
      <Nav countCartItem = {cartItems.length} onAdd={onAdd} cartItems = {cartItems}></Nav>

      <Switch>
          <Route exact path="/"component={CSPartsList}></Route>
        <Route exact path="/homepage"component={CSPartsList}></Route>
        <Route path="/details" component={<Detail data={1}/>} />
        <Route path="/cart"render={(props) => <Cart data={cartItems} onAdd={onAdd} onRemove={{onRemove}}{...props}/>}></Route>
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
        <Route path="/ListProduct/:id" render={(props) => <Detail data={cartItems} onAdd={onAdd} onRemove={{onRemove}}{...props}/>} exact></Route>
        <Route component={Default}></Route>


      </Switch>


     </React.Fragment>  
      );
   

  
  
}


