import React, { Component } from "react";
import "./App.css";
import axios from "axios";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
      isLoading: false,
    };
  }

  componentDidMount() {
    axios
      .get("http://localhost:8000/users")
      .then((response) =>
        this.setState({ users: response.data, isLoading: true })
      );
  }

  render() {
    let { isLoading, users } = this.state;

    if (!isLoading) {
      return (
        <div className="App">
          <div className="App-header">
            <p>Loading...</p>
          </div>
        </div>
      );
    } else {
      return (
        <div className="App">
          <div className="App-header">
            <ul>
              {users.map((user) => (
                <li key={user.id}>
                  Name :{user.name} | mobile: {user.mobile} | age {user.age}
                </li>
              ))}
            </ul>
          </div>
        </div>
      );
    }
  }
}

export default App;
