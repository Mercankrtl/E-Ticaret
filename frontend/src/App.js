import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import "./App.css";
import logo from "./logo.png";
import ProductCarousel from "./components/ProductCarousel";
import SeasonalColumns from "./components/SeasonalColumns";
import Footer from "./components/Footer";
import DailyDeals from "./components/DailyDeals";
import categories from "./data/categories";
import CategoryPage from "./pages/CategoryPage";
import Home from "./pages/Home";
import Login from "./pages/Login";
import SignupPage from "./pages/SignupPage";
import CartPage from "./pages/CartPage";  // ✅ Sepet sayfası
import { CartProvider } from "./context/CartContext"; // ✅ Sepet context

function App() {
    return (
        <Router>
            {/* ✅ CartProvider ile tüm uygulamayı sarmaladık */}
            <CartProvider>
                <div className="App">
                    {/* HEADER */}
                    <header className="header">
                        <div className="container">
                            <div className="header-inner">
                                {/* Sol kısım - Logo */}
                                <div className="logo">
                                    <Link to="/">
                                        <img src={logo} alt="EasyCart Logo" />
                                    </Link>
                                </div>

                                {/* Orta kısım - Arama Çubuğu */}
                                <div className="search-bar">
                                    <input
                                        type="text"
                                        placeholder="Ürün, kategori veya marka ara..."
                                    />
                                    <button>Ara</button>
                                </div>

                                {/* Sağ kısım - Kullanıcı ve Sepet */}
                                <div className="header-right">
                                    <Link to="/login" className="login-btn">
                                        Giriş Yap
                                    </Link>
                                    <Link to="/cart" className="cart-btn">
                                        Sepetim
                                    </Link>
                                </div>
                            </div>
                        </div>
                    </header>

                    {/* CATEGORY BAR */}
                    <div className="category-bar">
                        <div className="container">
                            {categories.map((cat) => (
                                <Link key={cat.id} to={`/category/${cat.slug}`}>
                                    {cat.name}
                                </Link>
                            ))}
                        </div>
                    </div>

                    {/* ROUTES */}
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/category/:slug" element={<CategoryPage />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/signup" element={<SignupPage />} />
                        <Route path="/cart" element={<CartPage />} /> {/* ✅ Sepet rotası */}
                    </Routes>

                    {/* FOOTER */}
                    <Footer />
                </div>
            </CartProvider>
        </Router>
    );
}

export default App;
