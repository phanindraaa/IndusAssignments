import axios from "axios";


const AuthService = {
    login: async (username, password) => {
      const response = await axios.post(
        "http://localhost:8080/login",
        new URLSearchParams({ username, password }).toString(),
        {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          withCredentials: true, // Include cookies
        }
      );
      localStorage.setItem("token", response.headers.authorization || ""); // Save token if applicable
    },
  
    logout: () => {
      localStorage.removeItem("token");
    },
  
    isAuthenticated: () => {
      return !!localStorage.getItem("token");
    },
  };
  
  export default AuthService;
  