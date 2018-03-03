import React from 'react';
import {render} from 'react-dom';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import App from './components/App';

const MainRouter = ({}) => {
  return (
    <Router>
      <Route path="/" component={App}/>
    </Router>
  );
};



render(<MainRouter />, document.getElementById('react-root'));