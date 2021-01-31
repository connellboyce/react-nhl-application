import React, {Component} from 'react';
import './App.css';


class App extends Component {
  constructor(props) {
      super(props);
      this.state = {
          error: null,
          isLoaded: false,
          teams: []
      };
  }

  componentDidMount() {
      fetch("http://localhost:9090/api/v1/teams")
          .then(res => res.json())
          .then(
              (result) => {
                  this.setState({
                      isLoaded: true,
                      teams: result._embedded.teams
                  });
              },
              (error) => {
                  this.setState({
                      isLoaded: true,
                      error
                  });
              }
          )
  }

  render() {
      const { error, isLoaded, teams } = this.state;
      if (error) {
          return <div>Error: {error.message}</div>;
      } else if (!isLoaded) {
          return <div>Loading...</div>
      } else {
          return (
              <table>
                  {teams.map(team => (
                      <tr key={team.id}>
                          <td><img alt={"Logo"} className={"teamLogo"} src={team.logoURL}/></td>
                          <td>{team.location} {team.name}</td>
                      </tr>
                  ))}
              </table>
          );
      }
  }
}

export default App;
