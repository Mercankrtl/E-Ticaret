import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { FaUser, FaLock } from "react-icons/fa";
import "./Auth.css";
import { loginUser } from "../services/api"; // Backend API fonksiyonu
import { useCart } from "../context/CartContext"; // CartContext import

function LoginPage() {
    const navigate = useNavigate();
    const { setUserId } = useCart(); // Context'ten setUserId alıyoruz
    const [emailOrUsername, setEmailOrUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("");

        try {
            const user = await loginUser({ emailOrUsername, password });
            console.log("Giriş başarılı:", user);

            // ✅ Login sonrası CartContext güncelle
            setUserId(user.userId);

            // Anasayfaya yönlendir
            navigate("/");
        } catch (err) {
            console.error(err);
            setError(err.message || "Giriş sırasında bir hata oluştu");
        }
    };

    return (
        <div className="login-page">
            <div className="login-box">
                <h2>Giriş Yap</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>Email veya Kullanıcı Adı</label>
                        <div className="input-with-icon">
                            <FaUser className="input-icon" />
                            <input
                                type="text"
                                placeholder="Email veya kullanıcı adı"
                                value={emailOrUsername}
                                onChange={(e) => setEmailOrUsername(e.target.value)}
                                required
                            />
                        </div>
                    </div>

                    <div className="form-group">
                        <label>Şifre</label>
                        <div className="input-with-icon">
                            <FaLock className="input-icon" />
                            <input
                                type="password"
                                placeholder="Şifre"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />
                        </div>
                    </div>

                    {error && <p className="error-text">{error}</p>}

                    <button type="submit" className="login-submit">
                        Giriş Yap
                    </button>

                    <p className="signup-text switch-link">
                        Hesabınız yok mu? <Link to="/signup">Kayıt Ol</Link>
                    </p>
                </form>
            </div>
        </div>
    );
}

export default LoginPage;
