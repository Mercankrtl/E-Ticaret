import React, { useRef, useState, useEffect } from "react";
import "./ProductCarousel.css";
import { fetchProducts } from "../services/api"; // backend API çağrısı

function ProductCarousel() {
  const carouselRef = useRef(null);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const getProducts = async () => {
      try {
        const data = await fetchProducts(); // backend'den ürünleri al
        setProducts(data);
      } catch (err) {
        console.error("Ürünler alınamadı:", err);
      }
    };
    getProducts();
  }, []);

  const scroll = (direction) => {
    const container = carouselRef.current;
    const scrollAmount = 270; // Bir ürün genişliği + gap

    if (direction === "left") {
      container.scrollLeft -= scrollAmount;
      if (container.scrollLeft <= 0) {
        container.scrollLeft = container.scrollWidth - container.clientWidth;
      }
    } else {
      container.scrollLeft += scrollAmount;
      if (container.scrollLeft >= container.scrollWidth - container.clientWidth) {
        container.scrollLeft = 0;
      }
    }
  };

  return (
    <div className="product-carousel-container">
      <button className="carousel-button left" onClick={() => scroll("left")}>
        &#8249;
      </button>

      <div className="product-carousel" ref={carouselRef}>
        {products.map((product) => (
          <div key={product.id} className="product-card">
            <img src={product.imageUrl || product.image} alt={product.name} />
            <h4>{product.name}</h4>
            <p>{product.price}₺</p>
            <button>Sepete Ekle</button>
          </div>
        ))}
      </div>

      <button className="carousel-button right" onClick={() => scroll("right")}>
        &#8250;
      </button>
    </div>
  );
}

export default ProductCarousel;
