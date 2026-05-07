import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");

  const API_URL = "http://localhost:8080/api/tasks";

  // Fetch Tasks
  const fetchTasks = async () => {
    const response = await axios.get(API_URL);
    setTasks(response.data);
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  // Add Task
  const addTask = async () => {

    if (!title.trim()) {
      return;
    }

    await axios.post(API_URL, {
      title: title
    });

    setTitle("");

    fetchTasks();
  };

  // Delete Task
  const deleteTask = async (id) => {

    await axios.delete(`${API_URL}/${id}`);

    fetchTasks();
  };

  return (
    <div style={{ padding: "20px" }}>

      <h1>To-Do App</h1>

      <input
        type="text"
        placeholder="Enter Task"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <button onClick={addTask}>
        Add
      </button>

      <ul>
        {tasks.map((task) => (
          <li key={task.id}>

            {task.title}

            <button
              onClick={() => deleteTask(task.id)}
              style={{ marginLeft: "10px" }}
            >
              Delete
            </button>

          </li>
        ))}
      </ul>

    </div>
  );
}

export default App;