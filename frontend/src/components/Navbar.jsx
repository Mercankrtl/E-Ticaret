// frontend/src/components/Navbar.jsx
import React from "react";
import { Link } from "react-router-dom";
import { FaShoppingCart } from "react-icons/fa";
import { useCart } from "../context/CartContext";
import "./Navbar.css";

export default function Navbar() {
    const { cartItems } = useCart();

    // Sepetteki toplam adet (quantity'ler yoksa 0 ile güvenli toplanır)
    const totalItems = cartItems.reduce((sum, item) => sum + (item.quantity || 0), 0);

    return (
        <header className="navbar">
            <div className="nav-left">
                <Link to="/" className="brand">E-Ticaret</Link>
            </div>

            <nav className="nav-right">
                <Link to="/categories" className="nav-link">Kategoriler</Link>

                <Link to="/cart" className="cart-link" aria-label="Sepet">
                    <FaShoppingCart size={22} />
                    {totalItems > 0 && <span className="cart-badge">{totalItems}</span>}
                </Link>
            </nav>
        </header>
    );
}
