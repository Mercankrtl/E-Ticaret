import React from "react";
import "./Footer.css";

export default function Footer() {
  return (
    <footer className="footer">
      <div className="container footer-inner">
        {/* Sol taraf */}
        <div className="footer-left">
          <h4>EasyCart</h4>
          <p>© 2025 EasyCart. Tüm hakları saklıdır.</p>
        </div>

        {/* Ortada linkler */}
        <div className="footer-links">
          <a href="#help">Yardım</a>
          <a href="#privacy">Gizlilik Politikası</a>
          <a href="#terms">Kullanım Şartları</a>
          <a href="#contact">İletişim</a>
        </div>

        {/* Sağ taraf */}
        <div className="footer-social">
          <a href="#facebook">Facebook</a>
          <a href="#twitter">Twitter</a>
          <a href="#instagram">Instagram</a>
        </div>
      </div>
    </footer>
  );
}
