import React from "react";
import { Link, useLocation } from "react-router-dom";
import "./OrderSuccess.css";

function OrderSuccess() {
    const location = useLocation();
    const { totalAmount } = location.state || {};

    return (
        <div className="order-success">
            <h2>✅ Siparişiniz Başarıyla Oluşturuldu!</h2>
            {totalAmount && <p>Toplam Tutar: {totalAmount} TL</p>}
            <Link to="/" className="back-home">
                🏠 Ana Sayfaya Dön
            </Link>
        </div>
    );
}

export default OrderSuccess;
