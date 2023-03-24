import React from "react";

export const Product = (props) => {
    const {id, productName, price, productImage} = props.data;
    return (
    <div className="products">
        <img src={productImage} />
        <div className="description">
            <p>{productName}</p>
            <p>${price}</p>
        </div>
    </div>


    );
}; 
