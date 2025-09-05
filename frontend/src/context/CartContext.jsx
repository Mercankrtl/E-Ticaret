import React, { createContext, useState, useContext, useEffect } from "react";
import { fetchCart, addProductToCartAPI, removeProductFromCartAPI, clearCartAPI } from "../services/cartApi";

const CartContext = createContext();

export function CartProvider({ children }) {
    // Test amaçlı sabit userId
    const [userId, setUserId] = useState(1); // ✅ Burayı login sonrası dinamik yapacağız
    const [cartItems, setCartItems] = useState([]);

    useEffect(() => {
        const loadCart = async () => {
            if (!userId) return;
            try {
                const cart = await fetchCart(userId);
                setCartItems(cart.items || []);
            } catch (error) {
                console.error("Sepet yüklenemedi:", error);
            }
        };
        loadCart();
    }, [userId]);

    const addToCart = async (product, quantity = 1) => {
        if (!userId) return alert("Lütfen giriş yapın!");
        try {
            const updatedCart = await addProductToCartAPI(userId, product.id, quantity);
            setCartItems(updatedCart.items);
        } catch (error) {
            console.error("Ürün eklenemedi:", error);
        }
    };

    const removeFromCart = async (productId) => {
        if (!userId) return alert("Lütfen giriş yapın!");
        try {
            const updatedCart = await removeProductFromCartAPI(userId, productId);
            setCartItems(updatedCart.items);
        } catch (error) {
            console.error("Ürün silinemedi:", error);
        }
    };

    const clearCart = async () => {
        if (!userId) return;
        try {
            const updatedCart = await clearCartAPI(userId);
            setCartItems(updatedCart.items);
        } catch (error) {
            console.error("Sepet temizlenemedi:", error);
        }
    };

    return (
        <CartContext.Provider value={{ cartItems, addToCart, removeFromCart, clearCart, userId, setUserId }}>
            {children}
        </CartContext.Provider>
    );
}

export function useCart() {
    return useContext(CartContext);
}
