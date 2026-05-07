import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");
  const [students, setStudents] = useState([]);

  // Fetch Students
  const fetchStudents = async () => {
    const response = await axios.get("http://localhost:8080/students");
    setStudents(response.data);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // Add Student
  const addStudent = async () => {
    await axios.post("http://localhost:8080/students", {
      name,
      age,
    });

    setName("");
    setAge("");

    fetchStudents();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Student Record System</h1>

      <input
        type="text"
        placeholder="Enter Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <input
        type="number"
        placeholder="Enter Age"
        value={age}
        onChange={(e) => setAge(e.target.value)}
        style={{ marginLeft: "10px" }}
      />

      <button onClick={addStudent} style={{ marginLeft: "10px" }}>
        Add Student
      </button>

      <h2>Student Records</h2>

      {students.length === 0 ? (
        <p>No Records Found</p>
      ) : (
        <ul>
          {students.map((student) => (
            <li key={student.id}>
              {student.name} - {student.age} years
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;