import React, { useRef, useEffect, useState } from "react";
import { fetchProducts } from "../services/api"; // api.js'de tanımlayacağız
import "./ProductCarousel.css";

function ProductCarousel() {
  const carouselRef = useRef(null);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts()
      .then((data) => setProducts(data))
      .catch((err) => console.error("Ürünler alınamadı:", err));
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
      {/* Sol ok */}
      <button className="carousel-button left" onClick={() => scroll("left")}>
        &#8249;
      </button>

      {/* Ürün listesi */}
      <div className="product-carousel" ref={carouselRef}>
        {products.length === 0 ? (
          <p>Ürünler yükleniyor...</p>
        ) : (
          products.map((product) => (
            <div key={product.id} className="product-card">
              <img src={product.imageUrl || product.image} alt={product.name} />
              <h4>{product.name}</h4>
              <p>{product.price}₺</p>
              <button>Sepete Ekle</button>
            </div>
          ))
        )}
      </div>

      {/* Sağ ok */}
      <button className="carousel-button right" onClick={() => scroll("right")}>
        &#8250;
      </button>
    </div>
  );
}

export default ProductCarousel;
