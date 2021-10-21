import React  from "react";
import Search  from "../Search/Search";
import {Link} from 'react-router-dom';
import cartLogo from '../icon/cart.svg';
import "bootstrap/dist/css/bootstrap.min.css";



import './Nav.css';

export default class Nav extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return (
            <nav className = "navbar bg-secondary navbar-dark px-sm-3">  
                <Link to='/'>
                        <h1 className="navbar-brand">MICROEGG</h1>
                </Link>
                <div className="info nav-item">
                <ul >
                            <Link to='/login'>
                                <li className="nav-link">Log in</li>
                            </Link>
                            <Link to='/account-create'>
                            <li className="nav-link">Create an account</li>
                            </Link>
                 </ul>
                </div>
                    <Link  to='/cart' className=" nav-item-cart">
                        <button>
                            <i className=" fas fa-cart-plus"/>
                            my cart
                        </button>
                    </Link>
           
                
                
            </nav>
        );
    }
}
