import axios from "axios";
import React from "react";

export default class DataServices{
    static retrieveAllProduct() {
        return axios.get('http://localhost:8081/api/product/all');
    }
    static searchByType(category){
        return axios.get(`http://localhost:8081/api/product/searchByType/${category}`);
    }
    static addToCart(){
        return axios.post('http://localhost:8081/api/order/addToCart');
    }
}