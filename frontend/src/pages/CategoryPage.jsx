import React from "react";
import { useParams } from "react-router-dom";
import products from "../data/products";
import ProductCard from "../components/ProductCard";

export default function CategoryPage() {
  const { slug } = useParams();

  let categoryProducts = [];

  if (slug === "cok-satanlar") {
    categoryProducts = products.filter((p) => p.isBestSeller);
  } else if (slug === "yeni-gelenler") {
    categoryProducts = products.filter((p) => p.isNew);
  } else {
    categoryProducts = products.filter(
      (p) => p.category?.toLowerCase() === slug.toLowerCase()
    );
  }

  return (
    <div style={{ maxWidth: "1100px", margin: "0 auto", padding: "0 20px" }}>
      <h2 style={{ fontSize: "24px", fontWeight: "bold", marginBottom: "20px" }}>
        {slug.replace("-", " ").toUpperCase()} Ürünleri
      </h2>

      {categoryProducts.length === 0 ? (
        <p>Bu kategoride ürün bulunamadı.</p>
      ) : (
        <div style={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fill, minmax(200px, 1fr))",
          gap: "20px"
        }}>
          {categoryProducts.map((p) => (
            <ProductCard key={p.id} product={p} />
          ))}
        </div>
      )}
    </div>
  );
}
