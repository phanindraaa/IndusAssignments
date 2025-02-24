import axios from "axios";

const API_URL = "http://localhost:8080/portfolios";

const PortfolioService = {
  getAllPortfolios: async () => {
    const response = await axios.get(API_URL, {
      headers: { Authorization: localStorage.getItem("token") },
    });
    return response.data;
  },
};

export default PortfolioService;
