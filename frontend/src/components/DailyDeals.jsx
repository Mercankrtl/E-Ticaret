import React, { useRef, useEffect, useState } from "react";
import { fetchDailyDeals } from "../services/api"; // api.js'de tanımlayacağız
import "./DailyDeals.css";

export default function DailyDeals() {
  const dealsRef = useRef(null);
  const [isHovered, setIsHovered] = useState(false);
  const isHoveredRef = useRef(false);
  const [dailyDeals, setDailyDeals] = useState([]);

  useEffect(() => {
    isHoveredRef.current = isHovered;
  }, [isHovered]);

  // Backend'den günlük indirimleri çek
  useEffect(() => {
    fetchDailyDeals()
      .then((data) => setDailyDeals(data))
      .catch((err) => console.error("Günlük indirimler alınamadı:", err));
  }, []);

  useEffect(() => {
    const container = dealsRef.current;
    const normalSpeed = 0.6;
    const hoverSpeed = 0.3;
    let scrollAmount = 0;
    let animationFrame;

    const scroll = () => {
      if (container && dailyDeals.length > 0) {
        const speed = isHoveredRef.current ? hoverSpeed : normalSpeed;
        scrollAmount += speed;

        // Sonsuz scroll: scroll sonuna yaklaşınca başa kaydır
        if (scrollAmount >= container.scrollWidth) {
          scrollAmount = 0;
        }

        container.scrollLeft = scrollAmount;
        animationFrame = requestAnimationFrame(scroll);
      }
    };

    scroll();

    return () => cancelAnimationFrame(animationFrame);
  }, [dailyDeals]);

  return (
    <section className="daily-deals">
      <div className="container">
        <h2>Günün İndirimleri</h2>
        <div
          className="deals-grid"
          ref={dealsRef}
          onMouseEnter={() => setIsHovered(true)}
          onMouseLeave={() => setIsHovered(false)}
        >
          {dailyDeals.length === 0 ? (
            <p>İndirimler yükleniyor...</p>
          ) : (
            <>
              {dailyDeals.map((p, index) => (
                <div key={index} className="deal-item">
                  <div className="thumb">
                    <img src={p.imageUrl || p.image} alt={p.name} />
                    <span className="badge">
                      -{Math.round((p.discount / p.price) * 100)}%
                    </span>
                  </div>
                  <h4>{p.name}</h4>
                  <div className="price">
                    <span className="old-price">{p.price}₺</span>
                    <span className="new-price">{p.price - p.discount}₺</span>
                  </div>
                  <button>Sepete Ekle</button>
                </div>
              ))}
              {/* Tekrar ederek boşluk olmasını önle */}
              {dailyDeals.map((p, index) => (
                <div key={dailyDeals.length + index} className="deal-item">
                  <div className="thumb">
                    <img src={p.imageUrl || p.image} alt={p.name} />
                    <span className="badge">
                      -{Math.round((p.discount / p.price) * 100)}%
                    </span>
                  </div>
                  <h4>{p.name}</h4>
                  <div className="price">
                    <span className="old-price">{p.price}₺</span>
                    <span className="new-price">{p.price - p.discount}₺</span>
                  </div>
                  <button>Sepete Ekle</button>
                </div>
              ))}
            </>
          )}
        </div>
      </div>
    </section>
  );
}
