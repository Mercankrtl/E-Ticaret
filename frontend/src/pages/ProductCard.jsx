import React from "react";
import { useCart } from "../context/CartContext";
import "./ProductCard.css";

function ProductCard({ product }) {
    const { addToCart } = useCart();

    const handleAddToCart = () => {
        addToCart(product);
    };

    return (
        <div className="product-card">
            <img src={product.image} alt={product.name} />
            <h3>{product.name}</h3>
            <p>{product.price} TL</p>
            <button onClick={handleAddToCart}>Sepete Ekle</button>
        </div>
    );
}

export default ProductCard;
