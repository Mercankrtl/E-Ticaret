// src/data/seasonalProducts.js

import winter1 from "./images/winter/winter1.webp";
import winter2 from "./images/winter/winter2.jpeg";
import winter3 from "./images/winter/winter3.jpg";
import winter4 from "./images/winter/winter4.jpg";

import spring1 from "./images/spring/spring1.jpg";
import spring2 from "./images/spring/spring2.webp";
import spring3 from "./images/spring/spring3.webp";
import spring4 from "./images/spring/spring4.webp";

import summer1 from "./images/summer/summer1.jpeg";
import summer2 from "./images/summer/summer2.webp";
import summer3 from "./images/summer/summer3.jpg";
import summer4 from "./images/summer/summer4.webp";

import autumn1 from "./images/autumn/autumn1.jpeg";
import autumn2 from "./images/autumn/autumn2.webp";
import autumn3 from "./images/autumn/autumn3.webp";
import autumn4 from "./images/autumn/autumn4.webp";

const seasonalProducts = {
  winter: [
    { id: 1, name: "Winter Jacket", price: 120, image: winter1 },
    { id: 2, name: "Snow Boots", price: 90, image: winter2 },
    { id: 3, name: "Wool Scarf", price: 25, image: winter3 },
    { id: 4, name: "Gloves", price: 15, image: winter4 },
  ],
  spring: [
    { id: 5, name: "Light Jacket", price: 60, image: spring1 },
    { id: 6, name: "Sneakers", price: 70, image: spring2 },
    { id: 7, name: "Floral Dress", price: 50, image: spring3 },
    { id: 8, name: "Cap", price: 20, image: spring4 },
  ],
  summer: [
    { id: 9, name: "T-Shirt", price: 25, image: summer1 },
    { id: 10, name: "Shorts", price: 30, image: summer2 },
    { id: 11, name: "Sandals", price: 35, image: summer3 },
    { id: 12, name: "Sunglasses", price: 40, image: summer4 },
  ],
  autumn: [
    { id: 13, name: "Hoodie", price: 55, image: autumn1 },
    { id: 14, name: "Jeans", price: 70, image: autumn2 },
    { id: 15, name: "Boots", price: 85, image: autumn3 },
    { id: 16, name: "Sweater", price: 50, image: autumn4 },
  ],
};

export default seasonalProducts;
