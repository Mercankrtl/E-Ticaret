// src/pages/CategoryPage.jsx
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ProductCard from "../components/ProductCard";
import { fetchProductsByCategory } from "../services/api";

export default function CategoryPage() {
    const { slug } = useParams();
    const [categoryProducts, setCategoryProducts] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        fetchProductsByCategory(slug)
            .then((data) => {
                // ✅ İsim ve fiyat bazlı uniq filtreleme
                const uniqueProducts = Array.from(
                    new Map(data.map(item => [`${item.name}-${item.price}`, item])).values()
                );
                setCategoryProducts(uniqueProducts);
                setLoading(false);
            })
            .catch((err) => {
                console.error(err);
                setError("Ürünler alınamadı");
                setLoading(false);
            });
    }, [slug]);

    if (loading) {
        return <p style={{ textAlign: "center", marginTop: "50px" }}>Yükleniyor...</p>;
    }

    if (error) {
        return <p style={{ textAlign: "center", marginTop: "50px", color: "red" }}>{error}</p>;
    }

    return (
        <div style={{ maxWidth: "1100px", margin: "0 auto", padding: "0 20px" }}>
            <h2 style={{ fontSize: "24px", fontWeight: "bold", marginBottom: "20px" }}>
                {slug.replace("-", " ").toUpperCase()} Ürünleri
            </h2>

            {categoryProducts.length === 0 ? (
                <p>Bu kategoride ürün bulunamadı.</p>
            ) : (
                <div
                    style={{
                        display: "grid",
                        gridTemplateColumns: "repeat(auto-fill, minmax(200px, 1fr))",
                        gap: "20px",
                    }}
                >
                    {categoryProducts.map((p) => (
                        <ProductCard key={p.id} product={p} />
                    ))}
                </div>
            )}
        </div>
    );
}
