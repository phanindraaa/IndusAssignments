import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Header from "./header";
import Body from "./body";
import Footer from "./footer";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Header />
    <Body />
    <Footer />
  </React.StrictMode>
);
