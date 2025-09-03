import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Auth.css";
import { signupUser } from "../services/api"; // backend API fonksiyonunu ekle

function SignupPage() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    gender: "",
    dateOfBirth: ""
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const user = await signupUser(formData);
      console.log("Kayıt başarılı:", user);
      navigate("/login"); // kayıt sonrası login sayfasına yönlendir
    } catch (err) {
      console.error(err);
      setError(err.message || "Kayıt sırasında bir hata oluştu");
    }
  };

  return (
    <div className="page-container">
      <div className="content-wrap">
        <div className="signup-box">
          <h2>Kayıt Ol</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Ad</label>
              <input
                type="text"
                name="firstName"
                placeholder="Adınızı girin"
                value={formData.firstName}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label>Soyad</label>
              <input
                type="text"
                name="lastName"
                placeholder="Soyadınızı girin"
                value={formData.lastName}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label>Kullanıcı Adı</label>
              <input
                type="text"
                name="username"
                placeholder="Kullanıcı adınızı girin"
                value={formData.username}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label>E-posta</label>
              <input
                type="email"
                name="email"
                placeholder="E-posta adresinizi girin"
                value={formData.email}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label>Şifre</label>
              <input
                type="password"
                name="password"
                placeholder="Şifrenizi girin"
                value={formData.password}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <label>Cinsiyet</label>
              <select name="gender" value={formData.gender} onChange={handleChange}>
                <option value="">Seçiniz</option>
                <option value="male">Erkek</option>
                <option value="female">Kadın</option>
                <option value="other">Diğer</option>
              </select>
            </div>
            <div className="form-group">
              <label>Doğum Tarihi</label>
              <input
                type="date"
                name="dateOfBirth"
                value={formData.dateOfBirth}
                onChange={handleChange}
              />
            </div>

            {error && <p className="error-text">{error}</p>}

            <button type="submit" className="login-submit">
              Kayıt Ol
            </button>

            <p className="signup-text">
              Zaten hesabınız var mı? <Link to="/login">Giriş Yap</Link>
            </p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default SignupPage;
