import React, { Component } from 'react';
import './Cart.css';
import {Detail} from "../Detail/Detail";

export default function Cart(props) {
        const {data,onRemove,onAdd} = props
        const itemPrice = data.reduce((a, c) =>a + a.qty * c. price, 0)
    const taxPrice = itemPrice * 0.14;
    const shippingPrice = itemPrice > 2000 ? 0 : 20;
    const totalPrice = itemPrice + taxPrice + shippingPrice;

        return (
<div>
            <h2>Cart Items</h2>
    <div>
        {data.length === 0 && <div>Cart is empty</div>}
        {data.map((item) => (
            <div key={item.id} className="row">
                <div className="col-2">{item.name}</div>
                <div className="col-2">
                    <button onClick={() => onRemove(item)} className="remove">
                        -
                    </button>{' '}
                    <button onClick={() => onAdd(item)} className="add">
                        +
                    </button>
                </div>

                <div className="col-2 text-right">
                    {item.qty} x ${item.price.toFixed(2)}
                </div>
            </div>
        ))}

        {data.length !== 0 && (
            <>
                <hr></hr>
                <div className="row">
                    <div className="col-2">Items Price</div>
                    <div className="col-1 text-right">${itemPrice.toFixed(2)}</div>
                </div>
                <div className="row">
                    <div className="col-2">Tax Price</div>
                    <div className="col-1 text-right">${taxPrice.toFixed(2)}</div>
                </div>
                <div className="row">
                    <div className="col-2">Shipping Price</div>
                    <div className="col-1 text-right">
                        ${shippingPrice.toFixed(2)}
                    </div>
                </div>

                <div className="row">
                    <div className="col-2">
                        <strong>Total Price</strong>
                    </div>
                    <div className="col-1 text-right">
                        <strong>${totalPrice.toFixed(2)}</strong>
                    </div>
                </div>
                <hr />
                <div className="row">
                    <button onClick={() => alert('Implement Checkout!')}>
                        Checkout
                    </button>
                </div>
            </>
        )}
    </div>
</div>
        )

}
