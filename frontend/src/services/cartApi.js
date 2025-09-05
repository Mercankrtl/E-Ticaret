export const fetchCart = async (userId) => {
    const res = await fetch(`http://localhost:8080/api/carts/${userId}`);
    if (!res.ok) throw new Error("Sepet alınamadı");
    return await res.json();
};

export const addProductToCartAPI = async (userId, productId, quantity) => {
    const res = await fetch(`http://localhost:8080/api/carts/${userId}/add?productId=${productId}&quantity=${quantity}`, {
        method: 'POST',
    });
    if (!res.ok) throw new Error("Ürün eklenemedi");
    return await res.json();
};

export const removeProductFromCartAPI = async (userId, productId) => {
    const res = await fetch(`http://localhost:8080/api/carts/${userId}/remove/${productId}`, {
        method: 'DELETE',
    });
    if (!res.ok) throw new Error("Ürün silinemedi");
    return await res.json();
};

export const clearCartAPI = async (userId) => {
    const res = await fetch(`http://localhost:8080/api/carts/${userId}/clear`, {
        method: 'DELETE',
    });
    if (!res.ok) throw new Error("Sepet temizlenemedi");
    return await res.json();
};
