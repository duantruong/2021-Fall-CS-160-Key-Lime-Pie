import React, { Component } from 'react'
import './Detail.css';
import axios from "axios";
import * as cartItems from "rxjs/operators";
import {Link} from "react-router-dom";

export default class Detail extends Component {
    constructor(props) {
        super(props);
        this.state = {
           product: [],
        }
        this.getProduct = this.getProduct.bind(this);
        this.handleOnAdd = this.handleOnAdd.bind(this);

    }


    getProduct = () => {
        const cat = this.props.location.state;


        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'computercases') {
                return axios.get(`http://localhost:8081/api/product/getComputerCases/${this.props.match.params.id}`).then(
                    response => {
                        this.setState({product: response.data.data})

                    }
                )
            }

        }
       if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'motherboard') {
                return axios.get(`http://localhost:8081/api/product/getMotherBoardDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }
        else if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'cooling') {
                return axios.get(`http://localhost:8081/api/product/getCoolingProductDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }
        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'powersupply') {
                return axios.get(`http://localhost:8081/api/product/getPowerSupplyDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }
       if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'graphiccard') {
                return axios.get(`http://localhost:8081/api/product/getGraphicCardDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})

                    }
                )
            }
        }
        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'processors') {
                return axios.get(`http://localhost:8081/api/product/getRamDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }
        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'storages') {
                return axios.get(`http://localhost:8081/api/product/getStoragesDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }
        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'ram') {
                return axios.get(`http://localhost:8081/api/product/getRamDetail/${this.props.match.params.id}`).then(
                    response => {
                        console.log(response);
                        this.setState({product: response.data.data})
                    }
                )
            }
        }

    }
    componentDidMount() {
        this.getProduct();

    }
   handleOnAdd(product){
        const {data,onAdd} = this.props;
        onAdd(product);
        console.log(data.length)
   }

    render() {
        const  {data,onAdd} = this.props;

        const product = this.state.product;
        const cate = this.props.location.state;
        console.log(this.state.product)


        return (
            <div>

                <div className="container mt-5 bootdey">
                    <div className="col-md-12">
                        <section className="panel">
                            <div className="panel-body">
                                <div className="col-md-6">
                                    <div className="pro-img-details">
                                        <img src="./images/CPU.png" alt=""/>
                                    </div>

                                    <h4 className="pro-d-title">
                                        <a href="#" className="">
                                            {product.productName}
                                        </a>
                                    </h4>
                                    <p>
                                        {product.productDescription}
                                    </p>
                                    <div className="product_meta">
                                        <span className="posted_in"> <strong>Categories:</strong> <a rel="tag"
                                                                                                     href="#">{cate}</a>
                                          .</span>
                                    </div>
                                    <div className="m-bot15"><strong>Price : </strong> <span
                                        className="amount-old">${product.price}</span>
                                    </div>
                                    <div className="form-group">
                                        <label>Quantity</label>
                                        <input type="quantiy" placeholder="1" className="form-control quantity"/>
                                    </div>
                                    <p>
                                        <button onClick={() => this.handleOnAdd(product)} className="btn btn-round btn-danger" type="button">
                                            <i
                                            className="fa fa-shopping-cart"/> Add to Cart
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>



            </div>
        )
    }
}
