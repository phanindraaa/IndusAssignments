import React, { useEffect, useState } from "react";
import apiClient from "../apiClient";
import "../styles/Transactions.css";

const Transactions = () => {
  const [transactions, setTransactions] = useState([]);
  const [error, setError] = useState(null);
  const [action, setAction] = useState(""); // Track current action (add, get)
  const [newTransaction, setNewTransaction] = useState({
    portfolio: { portfolioId: "" },
    user: { userId: "" },
    transactionType: "",
    stockSymbol: "",
    quantity: 0,
    price: 0,
    status: "",
    timestamp: "",
  });
  const [userId, setUserId] = useState(""); // For "Get Transactions by User ID"

  // Fetch all transactions on component mount
  useEffect(() => {
    const fetchTransactions = async () => {
      try {
        const response = await apiClient.get("/transactions", {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
        });
        console.log("Fetched Transactions Data:", response.data); // Debugging
        setTransactions(response.data);
      } catch (err) {
        console.error("Error fetching transactions:", err);
        setError("Failed to fetch transactions.");
      }
    };

    fetchTransactions();
  }, []);

  // Add a new transaction
  const handleAddTransaction = async (e) => {
    e.preventDefault();
    console.log("New Transaction Payload:", newTransaction); // Debug payload
    try {
      const response = await apiClient.post("/transactions", newTransaction, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("token")}`,
          "Content-Type": "application/json",
        },
      });
      console.log("API Response for Add Transaction:", response.data); // Debug response
      setTransactions([...transactions, response.data]);
      setAction(""); // Close the form
      setNewTransaction({
        portfolio: { portfolioId: "" },
        user: { userId: "" },
        transactionType: "",
        stockSymbol: "",
        quantity: 0,
        price: 0,
        status: "",
        timestamp: "",
      });
    } catch (err) {
      console.error("Error adding transaction:", err);
      setError("Failed to add transaction.");
    }
  };

  // Get transactions by user ID
  const handleGetTransactionsByUserId = async (e) => {
    e.preventDefault();
    if (!userId) {
      setError("Please enter a valid User ID.");
      return;
    }

    try {
      const response = await apiClient.get(`/transactions/user/${userId}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
      });
      console.log("Fetched Transactions by User ID:", response.data); // Debug response
      setTransactions(response.data);
      setAction(""); // Close the form
      setUserId(""); // Reset user ID input
    } catch (err) {
      console.error("Error fetching transactions by user ID:", err);
      setError("Failed to fetch transactions by user ID.");
    }
  };

  return (
    <div className="transactions-container">
      <h2>Transaction Management</h2>
      {error && <p className="error">{error}</p>}

      <div className="transactions-actions">
        <button onClick={() => setAction("add")}>Add Transaction</button>
        <button onClick={() => setAction("get")}>Get Transactions by User ID</button>
      </div>

      {/* Add Transaction Form */}
      {action === "add" && (
        <form className="add-transaction-form" onSubmit={handleAddTransaction}>
          <input
            type="number"
            placeholder="Portfolio ID"
            value={newTransaction.portfolio.portfolioId}
            onChange={(e) =>
              setNewTransaction({
                ...newTransaction,
                portfolio: { portfolioId: parseInt(e.target.value, 10) || "" },
              })
            }
            required
          />
          <input
            type="number"
            placeholder="User ID"
            value={newTransaction.user.userId}
            onChange={(e) =>
              setNewTransaction({
                ...newTransaction,
                user: { userId: parseInt(e.target.value, 10) || "" },
              })
            }
            required
          />
          <input
            type="text"
            placeholder="Transaction Type"
            value={newTransaction.transactionType}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, transactionType: e.target.value })
            }
            required
          />
          <input
            type="text"
            placeholder="Stock Symbol"
            value={newTransaction.stockSymbol}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, stockSymbol: e.target.value })
            }
            required
          />
          <input
            type="number"
            placeholder="Quantity"
            value={newTransaction.quantity}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, quantity: parseInt(e.target.value, 10) || 0 })
            }
            required
          />
          <input
            type="number"
            placeholder="Price"
            value={newTransaction.price}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, price: parseFloat(e.target.value) || 0 })
            }
            required
          />
          <input
            type="text"
            placeholder="Status"
            value={newTransaction.status}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, status: e.target.value })
            }
            required
          />
          <input
            type="datetime-local"
            placeholder="Timestamp"
            value={newTransaction.timestamp}
            onChange={(e) =>
              setNewTransaction({ ...newTransaction, timestamp: e.target.value })
            }
            required
          />
          <button type="submit">Submit</button>
          <button type="button" onClick={() => setAction("")}>
            Cancel
          </button>
        </form>
      )}

      {/* Get Transactions by User ID Form */}
      {action === "get" && (
        <form className="get-transaction-form" onSubmit={handleGetTransactionsByUserId}>
          <input
            type="number"
            placeholder="Enter User ID"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            required
          />
          <button type="submit">Get Transactions</button>
          <button type="button" onClick={() => setAction("")}>
            Cancel
          </button>
        </form>
      )}

      {/* Display Transactions */}
      <table className="transactions-table">
        <thead>
          <tr>
            <th>Transaction ID</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>Stock Symbol</th>
            <th>Timestamp</th>
            <th>Type</th>
            <th>Portfolio ID</th>
            <th>User ID</th>
          </tr>
        </thead>
        <tbody>
          {transactions.map((transaction) => (
            <tr key={transaction.transactionId}>
              <td>{transaction.transactionId || "N/A"}</td>
              <td>{transaction.price || "N/A"}</td>
              <td>{transaction.quantity || "N/A"}</td>
              <td>{transaction.status || "N/A"}</td>
              <td>{transaction.stockSymbol || "N/A"}</td>
              <td>{transaction.timestamp || "N/A"}</td>
              <td>{transaction.transactionType || "N/A"}</td>
              <td>{transaction.portfolio?.portfolioId || "N/A"}</td>
              <td>{transaction.user?.userId || "N/A"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Transactions;
