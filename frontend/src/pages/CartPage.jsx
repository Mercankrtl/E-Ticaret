import React from "react";
import "./Cart.css";
import { FaTrash } from "react-icons/fa";
import { useCart } from "../context/CartContext";
import { createOrder } from "../services/orderApi";
import { useNavigate } from "react-router-dom";

function CartPage() {
    const { cartItems, removeFromCart, clearCart, userId } = useCart();
    const navigate = useNavigate();

    const totalPrice = cartItems.reduce((total, item) => total + item.price * item.quantity, 0);

    const handleCheckout = async () => {
        try {
            const order = await createOrder(userId, cartItems);
            clearCart();
            navigate("/order-success", { state: { totalAmount: order.totalAmount } });
        } catch (error) {
            alert("🚨 Sipariş oluşturulamadı: " + error.message);
            console.error(error);
        }
    };

    return (
        <div className="cart-page">
            <h2>Sepetim</h2>
            {cartItems.length === 0 ? (
                <p className="empty-cart">Sepetiniz boş</p>
            ) : (
                <div className="cart-container">
                    <div className="cart-items">
                        {cartItems.map((item) => (
                            <div key={item.id} className="cart-item">
                                <img src={item.image} alt={item.name} />
                                <div className="item-details">
                                    <h4>{item.name}</h4>
                                    <p>{item.price} TL</p>
                                    <p>Adet: {item.quantity}</p>
                                </div>
                                <button className="remove-btn" onClick={() => removeFromCart(item.id)}>
                                    <FaTrash />
                                </button>
                            </div>
                        ))}
                    </div>
                    <div className="cart-summary">
                        <h3>Toplam</h3>
                        <p>{totalPrice} TL</p>
                        <button className="checkout-btn" onClick={handleCheckout}>
                            Satın Al
                        </button>
                    </div>
                </div>
            )}
        </div>
    );
}

export default CartPage;
