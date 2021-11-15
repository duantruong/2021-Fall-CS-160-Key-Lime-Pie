import React, { Component } from 'react'
import './Detail.css';
import axios from "axios";
export default class Detail extends Component {
    constructor(props) {
        super(props);
        this.state = {
           product: [],
        }
        this.getProduct = this.getProduct.bind(this);
    }
    getProduct = () => {
        const cat = this.props.location.state;
        if (this.props.match.params.id) {
            if (cat.toLowerCase() === 'computercases') {
                return axios.get(`http://localhost:8081/getComputerCases/${this.props.match.params.id}`).then(
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

    render() {

        const product = this.state.product;
        const cate = this.props.location.state;

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
                                        <button className="btn btn-round btn-danger" type="button">
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
