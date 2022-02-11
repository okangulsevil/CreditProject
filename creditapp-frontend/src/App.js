import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

class App extends Component {
  state = {
    user: {}
  };

  async componentDidMount() {
    const response = await fetch('/v1/users/getById/1');
    const body = await response.json();
    this.setState({user: body});
  }

  render() {
    const {user} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Users</h2>
                  <div key={user.id}>
                    {user.firstName} {user.lastName} {user.identityNumber}
                  </div>
            </div>
          </header>
        </div>
    );
  }
}
export default App;
