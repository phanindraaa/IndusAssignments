import React from "react";
import { useNavigate } from "react-router-dom";
import "../styles/Home.css";

const Home = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token"); // Clear token on logout
    navigate("/login");
  };

  return (
    <div className="home-container">
      <h1>Welcome to the Finance Dashboard</h1>
      <div className="home-options">
        <button onClick={() => navigate("/Portfolios")}>Portfolios</button>
        <button onClick={() => navigate("/Transactions")}>Transactions</button>
        <button onClick={handleLogout}>Logout</button>
      </div>
    </div>
  );
};

export default Home;
