import React from 'react';
import {Route, Switch} from 'react-router-dom';
import EnforceLoginContainer from './auth/EnforceLoginContainer';
import Landing from './Landing';
import NotFound from './common/NotFound';

// Main component with login enforcement
const MainComponent = ({}) => {

  return (
    <EnforceLoginContainer>

      <div id="wrapper">
        <Switch>
          <Route path="/app" exact component={Landing}/>
          <Route component={NotFound}/>
        </Switch>

      </div>
    </EnforceLoginContainer>
  );
};

export default MainComponent;