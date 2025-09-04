import React, { createContext, useState, useContext } from "react";

// Sepet context oluştur
const CartContext = createContext();

// Provider
export function CartProvider({ children }) {
    const [cartItems, setCartItems] = useState([]);

    // Sepete ürün ekleme
    const addToCart = (product) => {
        setCartItems((prevItems) => {
            const existing = prevItems.find((item) => item.id === product.id);
            if (existing) {
                return prevItems.map((item) =>
                    item.id === product.id
                        ? { ...item, quantity: item.quantity + 1 }
                        : item
                );
            }
            return [...prevItems, { ...product, quantity: 1 }];
        });
    };

    // Sepetten ürün silme
    const removeFromCart = (id) => {
        setCartItems((prevItems) => prevItems.filter((item) => item.id !== id));
    };

    return (
        <CartContext.Provider value={{ cartItems, addToCart, removeFromCart }}>
            {children}
        </CartContext.Provider>
    );
}

// Context hook
export function useCart() {
    return useContext(CartContext);
}
