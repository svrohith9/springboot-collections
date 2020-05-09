import React, { Component } from "react";
import { PersonService } from "./services/PersonService";
import "./App.css";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Panel } from "primereact/panel";
import { Menubar } from "primereact/menubar";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import { Growl } from "primereact/growl";

import "primereact/resources/themes/nova-light/theme.css";
import "primereact/resources/primereact.min.css";
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
      selectedUser: {},
    };
    this.items = [
      {
        label: "New",
        icon: "pi pi-fw pi-plus",
        command: () => {
          this.showSaveDialog();
        },
      },
      {
        label: "Edit",
        icon: "pi pi-fw pi-pencil",
        command: () => {
          this.showEditDialog();
        },
      },
      {
        label: "Delete",
        icon: "pi pi-fw pi-trash",
        command: () => {
          this.delete();
        },
      },
    ];

    this.personService = new PersonService();
    this.save = this.save.bind(this);
    this.delete = this.delete.bind(this);
    this.footer = (
      <div>
        <Button label="Submit" icon="pi pi-check" onClick={this.save} />
      </div>
    );
  }

  componentDidMount() {
    this.personService.getAll().then((data) => this.setState({ users: data }));
  }

  save() {
    this.personService.save(this.state.user).then((data) => {
      this.setState({
        visible: false,
        user: {
          id: null,
          name: null,
          mobile: null,
          age: null,
        },
      });
      this.growl.show({
        summary: "Success!",
      });
      this.personService
        .getAll()
        .then((data) => this.setState({ users: data }));
    });
  }

  delete() {
    if (window.confirm("want to delete?")) {
      this.personService.delete(this.state.selectedUser.name).then((data) => {
        this.growl.show({
          summary: "Sucess!",
        });
        this.personService
          .getAll()
          .then((data) => this.setState({ users: data }));
      });
    }
  }

  showSaveDialog() {
    this.setState({
      visible: true,
      user: {
        id: null,
        name: null,
        mobile: null,
        age: null,
      },
    });
    document.getElementById("user-form");
  }

  showEditDialog() {
    this.setState({
      visible: true,
      user: {
        id: this.state.selectedUser.id,
        name: this.state.selectedUser.name,
        mobile: this.state.selectedUser.mobile,
        age: this.state.selectedUser.age,
      },
    });
  }

  render() {
    return (
      <div
        className="content-section implementation"
        style={{ width: "80%", margin: "0 auto", marginTop: "20px" }}
      >
        <Menubar model={this.items} />
        <br />
        <Panel header="Simple CRUD ">
          <DataTable
            value={this.state.users}
            paginator={true}
            rows="4"
            selectionMode="single"
            selection={this.state.selectedUser}
            onSelectionChange={(e) => this.setState({ selectedUser: e.value })}
          >
            <Column field="id" header="id"></Column>
            <Column field="name" header="name"></Column>
            <Column field="mobile" header="mobile"></Column>
            <Column field="age" header="age"></Column>
          </DataTable>
        </Panel>
        <Dialog
          header="Create new User"
          visible={this.state.visible}
          style={{ width: "400px" }}
          footer={this.footer}
          modal={true}
          onHide={() => this.setState({ visible: false })}
        >
          <form id="user-form">
            <span className="p-float-label">
              <InputText
                value={this.state.user.name}
                style={{ width: "100%" }}
                id="name"
                onChange={(e) => {
                  let val = e.target.value;
                  this.setState((prevState) => {
                    let user = Object.assign({}, prevState.user);
                    user.name = val;

                    return { user };
                  });
                }}
              />
              <label htmlFor="name">Name</label>
            </span>
            <br />
            <span className="p-float-label">
              <InputText
                value={this.state.user.age}
                style={{ width: "100%" }}
                id="age"
                onChange={(e) => {
                  let val = e.target.value;
                  this.setState((prevState) => {
                    let user = Object.assign({}, prevState.user);
                    user.age = val;

                    return { user };
                  });
                }}
              />
              <label htmlFor="age">Age</label>
            </span>
            <br />
            <span className="p-float-label">
              <InputText
                value={this.state.user.mobile}
                style={{ width: "100%" }}
                id="modile"
                onChange={(e) => {
                  let val = e.target.value;
                  this.setState((prevState) => {
                    let user = Object.assign({}, prevState.user);
                    user.mobile = val;

                    return { user };
                  });
                }}
              />
              <label htmlFor="mobile">Mobile</label>
            </span>
            <br />
          </form>
        </Dialog>
        <Growl ref={(el) => (this.growl = el)} />
      </div>
    );
  }
}

export default App;
