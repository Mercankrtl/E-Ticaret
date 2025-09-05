export const createOrder = async (userId, cartItems) => {
    try {
        const response = await fetch(`http://localhost:8080/api/orders`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userId, cartItems }), // ✅ userId eklendi
        });

        if (response.ok) {
            const order = await response.json();
            console.log('✅ Sipariş oluşturuldu:', order);
            return order;
        } else {
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
    } catch (error) {
        console.error('🚨 Hata:', error.message);
        throw error;
    }
};
