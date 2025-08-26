// ./src/data/products.js
import kadinTshirt from "./images/kadin-tshirt.webp";
import erkekAyakkabi from "./images/erkek-ayakkabi.jpg";
import kulaklik from "./images/kulaklik.webp";
import kiyafetTakim from "./images/kiyafet-takim.webp";
import yabanMersini from "./images/yaban-mersini.webp";
import aksesuarSeti from "./images/aksesuar.jpg";
import kolye from "./images/kolye.webp";
import laptop from "./images/laptop.jpeg";
import telefon from "./images/telefon.jpg";
import tablet from "./images/tablet.jpeg";
import elbise from "./images/elbise.webp";
import ceket from "./images/ceket.jpg";
import canta from "./images/canta.webp";
import kahveMakinesi from "./images/kahve-makinesi.webp";
import blender from "./images/blender.jpg";
import meyveSuyu from "./images/meyve-suyu.jpg";
import kosuAyakkabisi from "./images/kosu-ayakkabisi.jpg";
import yogaMati from "./images/yoga-mati.jpg";
import buzdolabi from "./images/buzdolabi.jpg";
import camasirMakinesi from "./images/camasir-makinesi.jpg";
import gozluk from "./images/gozluk.jpeg";
import mont from "./images/mont.webp";
import saat from "./images/saat.webp";
import bileklik from "./images/bileklik.webp";
import makarna from "./images/makarna.jpg";
import peynir from "./images/peynir.jpeg";
import lamba from "./images/lamba.webp";
import konsol from "./images/konsol.jpg";
import kulaklikStandi from "./images/kulaklik-standi.jpg";
import corap from "./images/corap.jpg";

const products = [
  { id: 1, name: "Kadın T-shirt", price: 149.99, image: kadinTshirt },
  { id: 2, name: "Erkek Ayakkabı", price: 299.99, image: erkekAyakkabi },
  { id: 3, name: "Elektronik Kulaklık", price: 199.99, image: kulaklik },
  { id: 4, name: "Kıyafet Takım", price: 399.99, image: kiyafetTakim },
  { id: 5, name: "Yaban Mersini", price: 49.99, image: yabanMersini },
  { id: 6, name: "Aksesuar Seti", price: 79.99, image: aksesuarSeti },
  { id: 7, name: "Kolye", price: 129.99, image: kolye },

  { id: 8,  name: "Laptop", price: 8999.99, image: laptop, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: true },
  { id: 9,  name: "Akıllı Telefon", price: 12999.99, image: telefon, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: true },
  { id: 10, name: "Tablet", price: 4999.99, image: tablet, category: "Elektronik", gender: "Unisex", isNew: true, isBestSeller: false },
  { id: 11, name: "Kadın Elbise", price: 349.99, image: elbise, category: "Kıyafet", gender: "Kadın", isNew: true, isBestSeller: false },
  { id: 12, name: "Erkek Ceket", price: 599.99, image: ceket, category: "Kıyafet", gender: "Erkek", isNew: false, isBestSeller: false },
  { id: 13, name: "Sırt Çantası", price: 249.99, image: canta, category: "Aksesuar", gender: "Unisex", isNew: true, isBestSeller: false },
  { id: 14, name: "Kahve Makinesi", price: 1499.99, image: kahveMakinesi, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 15, name: "Blender", price: 799.99, image: blender, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 16, name: "Meyve Suyu", price: 19.99, image: meyveSuyu, category: "Süpermarket", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 17, name: "Koşu Ayakkabısı", price: 699.99, image: kosuAyakkabisi, category: "Kıyafet", gender: "Erkek", isNew: false, isBestSeller: true },
  { id: 18, name: "Yoga Matı", price: 249.99, image: yogaMati, category: "Aksesuar", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 19, name: "Buzdolabı", price: 10499.99, image: buzdolabi, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 20, name: "Çamaşır Makinesi", price: 8499.99, image: camasirMakinesi, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 21, name: "Güneş Gözlüğü", price: 199.99, image: gozluk, category: "Aksesuar", gender: "Unisex", isNew: false, isBestSeller: true },
  { id: 22, name: "Erkek Mont", price: 799.99, image: mont, category: "Kıyafet", gender: "Erkek", isNew: true, isBestSeller: false },
  { id: 23, name: "Erkek Saat", price: 399.99, image: saat, category: "Aksesuar", gender: "Erkek", isNew: false, isBestSeller: false },
  { id: 24, name: "Bileklik", price: 89.99, image: bileklik, category: "Aksesuar", gender: "Kadın", isNew: false, isBestSeller: false },
  { id: 25, name: "Makarna", price: 14.99, image: makarna, category: "Süpermarket", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 26, name: "Peynir", price: 34.99, image: peynir, category: "Süpermarket", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 27, name: "Masa Lambası", price: 299.99, image: lamba, category: "Elektronik", gender: "Unisex", isNew: true, isBestSeller: false },
  { id: 28, name: "Oyun Konsolu", price: 15999.99, image: konsol, category: "Elektronik", gender: "Unisex", isNew: false, isBestSeller: true },
  { id: 29, name: "Kulaklık Standı", price: 199.99, image: kulaklikStandi, category: "Aksesuar", gender: "Unisex", isNew: false, isBestSeller: false },
  { id: 30, name: "Çorap", price: 29.99, image: corap, category: "Kıyafet", gender: "Unisex", isNew: false, isBestSeller: false },
];

export default products;