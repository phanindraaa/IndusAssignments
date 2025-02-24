import React, { useState } from "react";
import apiClient from "../apiClient";
import "../styles/GetPortfolio.css";

const GetPortfolio = () => {
  const [userId, setUserId] = useState("");
  const [portfolios, setPortfolios] = useState([]);
  const [error, setError] = useState(null);

  const fetchPortfolios = async () => {
    try {
      const response = await apiClient.get(`/portfolios/user/${userId}`);
      setPortfolios(response.data);
      setError(null);
    } catch (err) {
      setError("Failed to fetch portfolios for the given User ID.");
    }
  };

  return (
    <div className="get-portfolio-container">
      <h2>Get Portfolios by User ID</h2>
      {error && <p className="error">{error}</p>}
      <div>
        <input
          type="number"
          placeholder="Enter User ID"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        <button onClick={fetchPortfolios}>Fetch Portfolios</button>
      </div>
      <table className="portfolio-table">
        <thead>
          <tr>
            <th>Portfolio ID</th>
            <th>Stock Symbol</th>
            <th>Shares</th>
          </tr>
        </thead>
        <tbody>
          {portfolios.map((portfolio) => (
            <tr key={portfolio.portfolioId}>
              <td>{portfolio.portfolioId}</td>
              <td>{portfolio.stockSymbol}</td>
              <td>{portfolio.shares}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default GetPortfolio;
