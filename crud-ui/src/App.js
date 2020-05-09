import React, { Component } from "react";
import { PersonService } from "./services/PersonService";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Panel } from "primereact/panel";
import { Menubar } from "primereact/menubar";

import { Button } from "primereact/button";

import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/nova-dark/theme.css";
import "primeicons/primeicons.css";

class App extends Component {
  constructor(props) {
    super();
    this.state = {
      visible: false,
      user: {
        id: null,
        name: null,
        mobile: null,
        age: null,
      },
    };
    this.items = [
      {
        label: "New",
        icon: "pi pi-fw pi-plus",
        command: () => {
          this.saveDialog();
        },
      },
      {
        label: "Edit",
        icon: "pi pi-fw pi-pencil",
        command: () => {
          alert("Edited Succesfully");
        },
      },
      {
        label: "Delete",
        icon: "pi pi-fw pi-trash",
        command: () => {
          alert("Deleted Succesfully");
        },
      },
    ];

    this.personService = new PersonService();
    this.footer = (
      <div>
        <Button label="Submit" icon="pi pi-check" onClick={this.save} />
      </div>
    );
  }

  componentDidMount() {
    this.personService.getAll().then((data) => this.setState({ users: data }));
  }

  saveDialog() {
    this.setState({
      visible: true,
    });
  }

  render() {
    return (
      <div
        className="content-section implementation"
        style={{ width: "70%", margin: "0 auto", marginTop: "50px" }}
      >
        <Menubar model={this.items} />
        <Panel header="Simple CRUD ">
          <DataTable value={this.state.users}>
            <Column columnKey="id" field="id" header="id"></Column>
            <Column columnKey="name" field="name" header="name"></Column>
            <Column columnKey="mobile" field="mobile" header="mobile"></Column>
            <Column columnKey="age" field="age" header="age"></Column>
          </DataTable>
        </Panel>
      </div>
    );
  }
}

export default App;
