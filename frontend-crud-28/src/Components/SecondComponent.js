import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

export default class SecondComponent extends Component {
  constructor() {
    super();
    this.state = {
      counter: 0,
    };
    this.increment = this.increment.bind(this);
  }

  render() {
    return (
      <div>
        <button
          type="button"
          className="btn btn-outline-light"
          onClick={this.increment}
        >
          + 10
        </button>
        <br></br>
        <span>{this.state.counter}</span>
      </div>
    );
  }
  increment() {
    this.setState({ counter: this.state.counter + 10 });
  }
}
