import React, { useRef } from "react";
import products from "../data/products";
import "./ProductCarousel.css";

function ProductCarousel() {
  const carouselRef = useRef(null);

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
        {products.map((product) => (
          <div key={product.id} className="product-card">
            <img src={product.image} alt={product.name} />
            <h4>{product.name}</h4>
            <p>{product.price}₺</p>
            <button>Sepete Ekle</button>
          </div>
        ))}
      </div>

      {/* Sağ ok */}
      <button className="carousel-button right" onClick={() => scroll("right")}>
        &#8250;
      </button>
    </div>
  );
}

export default ProductCarousel;
