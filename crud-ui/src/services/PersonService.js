import axios from "axios";
export class PersonService {
  baseUrl = "http://localhost:8000/";
  getAll() {
    return axios.get(this.baseUrl + "users").then((res) => res.data);
  }

  save(user) {
    return axios.post(this.baseUrl + "load", user).then((res) => res.data);
  }

  delete(id) {
    return axios.get(this.baseUrl + "delete/" + id).then((res) => res.data);
  }
}
