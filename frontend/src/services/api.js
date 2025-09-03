const API_BASE_URL = "http://localhost:8080/api"; // backend URL'in

// Tüm ürünleri getir
export async function fetchProducts() {
  const response = await fetch(`${API_BASE_URL}/products`);
  if (!response.ok) {
    throw new Error("Ürünler alınamadı");
  }
  return response.json();
}

// Belirli kategorideki ürünleri getir
export async function fetchProductsByCategory(categorySlug) {
  const response = await fetch(`${API_BASE_URL}/products/category/${categorySlug}`);
  if (!response.ok) {
    throw new Error("Kategori ürünleri alınamadı");
  }
  return response.json();
}

// Sezonluk ürünleri getir
export async function fetchSeasonalProducts() {
  const response = await fetch(`${API_BASE_URL}/seasonal-products`);
  if (!response.ok) {
    throw new Error("Sezonluk ürünler alınamadı");
  }
  return response.json();
}

// Günün indirimlerini getir
export async function fetchDailyDeals() {
  const response = await fetch(`${API_BASE_URL}/daily-deals`);
  if (!response.ok) {
    throw new Error("Günün indirimleri alınamadı");
  }
  return response.json();
}

// Kullanıcı kayıt
export async function signupUser(data) {
  const response = await fetch(`${API_BASE_URL}/users/signup`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!response.ok) {
    const text = await response.text();
    throw new Error(text || "Kayıt başarısız");
  }
  return response.json();
}

// Kullanıcı giriş
export async function loginUser(data) {
  const response = await fetch(`${API_BASE_URL}/users/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!response.ok) {
    const text = await response.text();
    throw new Error(text || "Giriş başarısız");
  }
  return response.json();
}
