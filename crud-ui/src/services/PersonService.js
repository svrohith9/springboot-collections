import axios from "axios";
export class PersonService {
  baseUrl = "http://localhost:8000/";
  getAll() {
    return axios.get(this.baseUrl + "users").then((res) => res.data);
  }
}
