// src/pages/Home.jsx
import React from "react";
import DailyDeals from "../components/DailyDeals";
import ProductCarousel from "../components/ProductCarousel";
import SeasonalColumns from "../components/SeasonalColumns";

export default function Home() {
  return (
    <>
      <DailyDeals />
      <ProductCarousel />
      <SeasonalColumns />
    </>
  );
}
