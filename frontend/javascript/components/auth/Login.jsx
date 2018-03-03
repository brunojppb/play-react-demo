import React, { Component } from 'react';
import {Link} from 'react-router-dom';


export default class Login extends Component {

  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: ''
    };
  }

  render() {

    const onLogin = (form) => {
      form.preventDefault();
      const { email, password } = this.state;
      console.log("Login...", email, password);
    };

    const onFieldChange = (field, value) => {
      this.setState({...this.state, [field]: value});
    };

    const { email, password } = this.state;
    const isButtonEnabled = email.length > 0 && password.length >= 6;

    return (
      <div className="container">
        <div className="row">
          <div className="col-sm-6 col-md-4 col-md-offset-4">

            <h1 className="text-center login-title">Todo List App</h1>

              <form className="form" onSubmit={onLogin}>
                <div className="form-group">
                  <input type="email"
                         className="form-control"
                         placeholder="Email"
                         required
                         onChange={(e) => onFieldChange('email', e.target.value)}/>
                </div>
                <div className="form-group">
                  <input type="password"
                         className="form-control"
                         placeholder="password"
                         name="password"
                         required
                         onChange={(e) => onFieldChange('password', e.target.value)}/>
                </div>
                <div className="form-group">
                  <button className="btn btn-lg btn-danger btn-block" type="submit" disabled={!isButtonEnabled}>Login</button>
                </div>

                <Link to="/app" className="pull-right">
                  Go to main page
                </Link>
                <span className="clearfix"/>
              </form>

          </div>
        </div>
      </div>
    );

  }

}