import React from "react";
import "./App.css";
import SecondComponent from "./Components/SecondComponent";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <SecondComponent></SecondComponent>
        <SecondComponent></SecondComponent>
      </header>
    </div>
  );
}

export default App;
