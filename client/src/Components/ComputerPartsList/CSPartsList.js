import React from 'react';
import './CSPartsList.css';
import ComputerParts from '../ComputerParts/ComputerParts';
import Categories from '../Categories/Categories';
import {categories} from '../../data';

const categoriesList_r1 = categories.map((item) => 
    
    <div className="card m-4 align-content-center" key={item.id}>
        <div className="imgwrapper align-content-center">
            <img  className="card-img-top  img-fluid p-4" src={item.image}/>
        </div>
        <div className="card-title text-center p-2">
            <h2>{item.title}</h2>
        </div>
    </div>
   
);

export default class CSPartsList extends React.Component{
   
    render(){
      
        return (
            <React.Fragment>
                <div class="card-deck p-5 d-flex flex-wrap" >
                   {categoriesList_r1}
                </div>
            </React.Fragment>
        );
    }
}
