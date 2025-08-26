import React from "react";

function ProductCard({ product }) {
  return (
    <div style={{
      border: "1px solid #ddd",
      borderRadius: "8px",
      padding: "10px",
      display: "flex",
      flexDirection: "column",
      alignItems: "center"
    }}>
      <img
        src={product.image}
        alt={product.name}
        style={{
          width: "100%",
          maxWidth: "180px",
          height: "180px",
          objectFit: "cover",
          borderRadius: "8px"
        }}
      />
      <h3 style={{ marginTop: "10px", fontSize: "16px", textAlign: "center" }}>
        {product.name}
      </h3>
      {product.category && <p style={{ color: "#888" }}>{product.category}</p>}
      <p style={{ color: "red", fontWeight: "bold" }}>{product.price} ₺</p>
      <button style={{
        marginTop: "10px",
        backgroundColor: "#051960",
        color: "white",
        border: "none",
        padding: "6px 12px",
        borderRadius: "5px",
        cursor: "pointer"
      }}>
        Sepete Ekle
      </button>
    </div>
  );
}

export default ProductCard;
