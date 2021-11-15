import React from 'react';
import './CSPartsList.css';
import ComputerParts from '../ComputerParts/ComputerParts';
import Categories from '../Categories/Categories';
import {categories} from '../../data';
import {Link} from 'react-router-dom';
import axios from 'axios';
import ListProduct from "../ListProduct";


const categoriesList_r1 = categories.map((item) => 
    
    <div className="card m-4 align-content-center" key={item.id}>
        <div className="imgwrapper align-content-center">
            <img  className="card-img-top  img-fluid p-4" src={item.image}/>
        </div>
        <div className="card-title text-center p-2">
            <Link to={item.path}>
                <a href="#" className="stretched-link"><h2>{item.title}</h2></a>
            </Link>

        </div>
    </div>
   
);


export default class CSPartsList extends React.Component{
   
    render(){
      
        return (
            <React.Fragment>
                <div className="card-deck p-5 d-flex flex-wrap justify-content-center" >
                   {categoriesList_r1}

                </div>
                <div className="text-center mb-5">
                    <Link to='/list-all-products'>
                        <h3>List all product</h3>
                    </Link>

                </div>

            </React.Fragment>
        );
    }
}
