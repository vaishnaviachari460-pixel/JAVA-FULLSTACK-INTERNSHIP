import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const register = async () => {
    const response = await axios.post(
      "http://localhost:8080/auth/register",
      {
        username,
        password,
      }
    );

    alert(response.data);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Register</h1>

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

      <button onClick={register}>Register</button>

      <p>
        Already have account? <Link to="/">Login</Link>
      </p>
    </div>
  );
}

export default Register;