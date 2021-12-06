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
                <div className="container">
                    <table className="table text-white">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>name</th>

                            <th>make</th>
                            <th>price</th>
                            <th>category</th>
                            <th>Detail</th>

                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.products.map(
                                product =>
                                    <tr key={product.productId}>
                                        <td>{product.productId}</td>
                                        <td>{product.productName}</td>
                                        <td>{product.make}</td>
                                        <td>${product.price}</td>
                                        <td>{product.category}</td>
                                        <td><Link to={
                                            {pathname: `/ListProduct/${product.productId}`,
                                                state:`${product.category}`}}
                                                  className="btn btn-primary align-items-center ">Detail
                                        </Link></td>

                                    </tr>
                            )
                        }

                        </tbody>
                    </table>
                </div>
            </div>
        )

    }


}
