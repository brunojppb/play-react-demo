import React, { Component } from 'react';
import {Route, Switch} from 'react-router-dom';
import MainComponent from './MainComponent';
import Login from './auth/Login';

export default class App extends Component {

  render() {

    return (
      <div>
        <Switch>
          <Route path="/app/login" exact component={Login}/>
          <Route component={MainComponent}/>
        </Switch>
      </div>
    );

  }

}