import { useCart } from "../context/CartContext";
import "./ProductCard.css"; // ✅ CSS import edildi

function ProductCard({ product }) {
    const { addToCart } = useCart();

    return (
        <div className="product-card">
            <img src={product.image} alt={product.name} />
            <h4>{product.name}</h4>
            <p>{product.price} TL</p>
            <button onClick={() => addToCart(product)}>Sepete Ekle</button>
        </div>
    );
}

export default ProductCard;
