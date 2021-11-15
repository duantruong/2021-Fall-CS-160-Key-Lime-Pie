import React,{ Component } from "react";
import DataServices from "./DataServices";
import axios from "axios";
import {Link} from "react-router-dom";
export default class ListProduct extends Component{
    constructor(props) {
        super(props);
        this.state = {
            products: [],
            message: null
        }
        this.refreshProducts = this.refreshProducts.bind(this);

    }
    componentDidMount(){
        this.refreshProducts();

    }
    refreshProducts(){
        DataServices.retrieveAllProduct().then(
            response => {
                console.log(response);
                this.setState({products: response
                        .data.data})

            }
        )
    }

    render(){
        return (
            <div>
                <h3 className= "text-center">
                    All Products
                </h3>
                <div  class="card-deck  d-flex flex-wrap justify-content-center">

                        {
                            this.state.products.map(
                                product =>

                                    <div className="card m-4 align-content-center w-10px" key={product.id}>
                                        <div className="imgwrapper align-content-center">
                                            <img  className="card-img-top  img-fluid p-4" src="./images/Computer_Case.png"/>
                                        </div>
                                        <div className="card-body align-content-center">

                                        <div className="card-title text-center p-2">
                                           {product.productName}
                                        </div>
                                            <div className="align-content-center p-2">
                                                <p>${product.price}</p>
                                            </div>
                                            <div className="align-content-center p-2">
                                                <Link to={
                                                    {pathname: `/ListProduct/${product.productId}`,
                                                        state:`${product.category}`}}
                                                     className="btn btn-primary align-items-center ">Detail
                                                </Link>

                                            </div>

                                    </div>
                                    </div>
                            )

                        }

                </div>

            </div>
        )
    }
}
