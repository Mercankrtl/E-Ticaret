import React, { useState, useEffect } from "react";
import "./SeasonalColumns.css";
import { fetchSeasonalProducts } from "../services/api"; // api.js'de tanımlayacağız

const SEASONS = [
  { key: "spring", label: "İlkbahar" },
  { key: "summer", label: "Yaz" },
  { key: "autumn", label: "Sonbahar" },
  { key: "winter", label: "Kış" },
];

export default function SeasonalColumns() {
  const [expanded, setExpanded] = useState(null);
  const [seasonalProducts, setSeasonalProducts] = useState({});

  // Backend'den sezonluk ürünleri çek
  useEffect(() => {
    fetchSeasonalProducts()
      .then((data) => setSeasonalProducts(data))
      .catch((err) => console.error("Sezonluk ürünler alınamadı:", err));
  }, []);

  return (
    <section className="seasonal-container">
      {SEASONS.map((s) => {
        const products = seasonalProducts[s.key] || [];

        return (
          <div
            key={s.key}
            className={`season-column season-${s.key} ${
              expanded === s.key ? "expanded" : ""
            }`}
            onMouseEnter={() => setExpanded(s.key)}
            onMouseLeave={() => setExpanded(null)}
          >
            {/* Banner / Başlık */}
            <header className="season-header">
              <h3>{s.label}</h3>
              <span className="badge">{products.length} ürün</span>
            </header>

            {/* Hover olduğunda gözükecek ürünler */}
            <div className="season-items">
              {products.map((p) => (
                <article className="season-item" key={p.id}>
                  <div className="thumb">
                    <img src={p.imageUrl || p.image} alt={p.name} loading="lazy" />
                  </div>
                  <div className="meta">
                    <h4 className="name">{p.name}</h4>
                    <div className="price">{p.price}₺</div>
                    <button className="add">Sepete Ekle</button>
                  </div>
                </article>
              ))}
            </div>
          </div>
        );
      })}
    </section>
  );
}
