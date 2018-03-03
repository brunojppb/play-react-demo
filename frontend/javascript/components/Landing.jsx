import React, { Component } from 'react';
import { Link } from 'react-router-dom';

const Landing = ({}) => {

  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-md-12">
          <h1>Todo List app</h1>
          <Link to="/app/login">Login</Link>
        </div>
      </div>
    </div>
  );

};

export default Landing;