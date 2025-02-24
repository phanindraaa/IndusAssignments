import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import apiClient from "../apiClient";
import "../styles/Portfolios.css";

const Portfolio = () => {
  const [portfolios, setPortfolios] = useState([]);
  const [newPortfolio, setNewPortfolio] = useState({
    user: { userId: "" },
    stockSymbol: "",
    shares: 0,
  });
  const [error, setError] = useState(null);
  const [action, setAction] = useState(""); // Track current action
  const [portfolioIdToDelete, setPortfolioIdToDelete] = useState("");

  const navigate = useNavigate();

  // Fetch all portfolios on component mount
  useEffect(() => {
    const fetchPortfolios = async () => {
      try {
        const response = await apiClient.get("/portfolios", {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
        });
        console.log("Fetched Portfolios:", response.data);
        setPortfolios(response.data);
      } catch (err) {
        console.error("Error fetching portfolios:", err);
        setError("Failed to fetch portfolios.");
      }
    };

    fetchPortfolios();
  }, []);

  // Add a new portfolio
  const handleAddPortfolio = async (e) => {
    e.preventDefault();
    const payload = {
      stockSymbol: newPortfolio.stockSymbol,
      shares: parseInt(newPortfolio.shares, 10),
      user: { userId: parseInt(newPortfolio.user.userId, 10) },
    };

    console.log("New Portfolio Payload:", payload);

    try {
      const response = await apiClient.post("/portfolios", payload, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("token")}`,
          "Content-Type": "application/json",
        },
      });
      console.log("API Response for Add Portfolio:", response.data);
      setPortfolios([...portfolios, response.data]);
      setAction(""); // Close the form
      setNewPortfolio({
        user: { userId: "" },
        stockSymbol: "",
        shares: 0,
      });
    } catch (err) {
      console.error("Error adding portfolio:", err);
      setError("Failed to add portfolio.");
    }
  };

  // Delete a portfolio
  const handleDeletePortfolio = async (e) => {
    e.preventDefault();
    if (!portfolioIdToDelete) {
      setError("Please enter a Portfolio ID to delete.");
      return;
    }

    console.log("Portfolio ID to Delete:", portfolioIdToDelete);

    try {
      await apiClient.delete(`/portfolios/${portfolioIdToDelete}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
      });
      setPortfolios(
        portfolios.filter((portfolio) => portfolio.portfolioId !== parseInt(portfolioIdToDelete, 10))
      );
      setPortfolioIdToDelete("");
      setAction(""); // Close the form
    } catch (err) {
      console.error("Error deleting portfolio:", err);
      setError("Failed to delete portfolio.");
    }
  };

  // Navigate to the "Get Portfolio by User ID" page
  const handleGetPortfolioByUserId = () => {
    navigate("/portfolios/user");
  };

  return (
    <div className="portfolio-container">
      <h2>Portfolio Management</h2>
      {error && <p className="error">{error}</p>}

      <div className="portfolio-actions">
        <button onClick={() => setAction("add")}>Add Portfolio</button>
        <button onClick={() => setAction("delete")}>Delete Portfolio</button>
        <button onClick={handleGetPortfolioByUserId}>Get Portfolio by ID</button>
      </div>

      {/* Add Portfolio Form */}
      {action === "add" && (
        <form className="add-portfolio-form" onSubmit={handleAddPortfolio}>
          <input
            type="number"
            placeholder="User ID"
            value={newPortfolio.user.userId}
            onChange={(e) => {
              const userId = parseInt(e.target.value, 10);
              if (!Number.isNaN(userId)) {
                setNewPortfolio({ ...newPortfolio, user: { userId } });
              } else {
                setNewPortfolio({ ...newPortfolio, user: { userId: "" } });
              }
            }}
            required
          />
          <input
            type="text"
            placeholder="Stock Symbol"
            value={newPortfolio.stockSymbol}
            onChange={(e) => setNewPortfolio({ ...newPortfolio, stockSymbol: e.target.value })}
            required
          />
          <input
            type="number"
            placeholder="Shares"
            value={newPortfolio.shares || ""}
            onChange={(e) => {
              const shares = parseInt(e.target.value, 10);
              setNewPortfolio({ ...newPortfolio, shares: Number.isNaN(shares) ? 0 : shares });
            }}
            required
          />
          <button type="submit">Submit</button>
          <button type="button" onClick={() => setAction("")}>
            Cancel
          </button>
        </form>
      )}

      {/* Delete Portfolio Form */}
      {action === "delete" && (
        <form className="delete-portfolio-form" onSubmit={handleDeletePortfolio}>
          <input
            type="number"
            placeholder="Portfolio ID to Delete"
            value={portfolioIdToDelete}
            onChange={(e) => setPortfolioIdToDelete(e.target.value)}
            required
          />
          <button type="submit">Delete</button>
          <button type="button" onClick={() => setAction("")}>
            Cancel
          </button>
        </form>
      )}

      {/* Display Portfolios */}
      <table className="portfolio-table">
        <thead>
          <tr>
            <th>Portfolio ID</th>
            <th>User ID</th>
            <th>Stock Symbol</th>
            <th>Shares</th>
          </tr>
        </thead>
        <tbody>
          {portfolios.map((portfolio) => (
            <tr key={portfolio.portfolioId}>
              <td>{portfolio.portfolioId}</td>
              <td>{portfolio.user?.userId}</td>
              <td>{portfolio.stockSymbol}</td>
              <td>{portfolio.shares}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Portfolio;
