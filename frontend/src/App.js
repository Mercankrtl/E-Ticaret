import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import "./App.css";
import logo from "./logo.png";
import categories from "./data/categories";
import Home from "./pages/Home";
import CategoryPage from "./pages/CategoryPage";
import Login from "./pages/Login";
import SignupPage from "./pages/SignupPage";
import CartPage from "./pages/CartPage";
import OrderSuccess from "./pages/OrderSuccess";
import Footer from "./components/Footer";
import { CartProvider, useCart } from "./context/CartContext";

// Sepet butonu
function CartButton() {
    const { cartItems } = useCart();
    const totalItems = cartItems.reduce((sum, item) => sum + (item.quantity || 0), 0);

    return (
        <Link to="/cart" className="cart-btn" style={{ position: "relative" }}>
            Sepetim
            {totalItems > 0 && (
                <span
                    style={{
                        position: "absolute",
                        top: "-8px",
                        right: "-12px",
                        background: "#ff69b4",
                        color: "white",
                        borderRadius: "50%",
                        padding: "2px 6px",
                        fontSize: "12px",
                        fontWeight: "bold",
                        animation: "pop 0.3s",
                    }}
                >
                    {totalItems}
                </span>
            )}
        </Link>
    );
}

function App() {
    return (
        <Router>
            <CartProvider>
                <div className="App">
                    <header className="header">
                        <div className="container">
                            <div className="header-inner">
                                <div className="logo">
                                    <Link to="/"><img src={logo} alt="EasyCart Logo" /></Link>
                                </div>
                                <div className="search-bar">
                                    <input type="text" placeholder="Ürün, kategori veya marka ara..." />
                                    <button>Ara</button>
                                </div>
                                <div className="header-right">
                                    <Link to="/login" className="login-btn">Giriş Yap</Link>
                                    <CartButton />
                                </div>
                            </div>
                        </div>
                    </header>

                    <div className="category-bar">
                        <div className="container">
                            {categories.map((cat) => (
                                <Link key={cat.id} to={`/category/${cat.slug}`}>{cat.name}</Link>
                            ))}
                        </div>
                    </div>

                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/category/:slug" element={<CategoryPage />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/signup" element={<SignupPage />} />
                        <Route path="/cart" element={<CartPage />} />
                        <Route path="/order-success" element={<OrderSuccess />} />
                    </Routes>

                    <Footer />
                </div>
            </CartProvider>
        </Router>
    );
}

export default App;
