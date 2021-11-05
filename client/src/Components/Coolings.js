import React, {Component} from 'react';
import DataServices from "./DataServices";

class Coolings extends Component {
    constructor(props) {
        super(props);
        this.state = {
            products: [],
            message: null
        }
        this.refreshProducts = this.refreshProducts.bind(this);
    }
    componentDidMount() {
        this.refreshProducts();
    }
    refreshProducts(){
        DataServices.searchByType("cooling").then (
            response => {
                console.log(response);
                this.setState({products: response.data.data})
            }
        )
    }
    render() {
        return (
            <div>
                <div className="container">
                    <h3>
                        All Coolings
                    </h3>
                    <div className="container">
                        <table className="table text-white">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>name</th>
                                <th>Description</th>
                                <th>make</th>
                                <th>price</th>
                                <th>category</th>

                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.products.map(
                                    product =>
                                        <tr key={product.productId}>
                                            <td>{product.productId}</td>
                                            <td>{product.productName}</td>
                                            <td>{product.productDescription}</td>
                                            <td>{product.make}</td>
                                            <td>{product.price}</td>
                                            <td>{product.category}</td>

                                        </tr>
                                )
                            }

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }
}

export default Coolings;