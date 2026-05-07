import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const login = async () => {
    const response = await axios.post(
      "http://localhost:8080/auth/login",
      {
        username,
        password,
      }
    );

    alert(response.data);

    if (response.data === "Login Successful") {
      navigate("/dashboard");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Login</h1>

      <input
        type="text"
        placeholder="Enter Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />

      <br /><br />

      <input
        type="password"
        placeholder="Enter Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <br /><br />

      <button onClick={login}>Login</button>

      <p>
        New User? <Link to="/register">Register</Link>
      </p>
    </div>
  );
}

export default Login;