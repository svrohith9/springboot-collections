import React, { Component } from "react";
import axios from "axios";
export class PersonService {
  baseUrl = "http://localhost:8080/";
  getAll() {
    axios.get(this.baseUrl + "/users").then((res) => res.data.data);
  }
}
