import React, { Component } from 'react';

export default class EnforceLoginContainer extends Component {

  componentDidMount() {
  }

  render() {

    const { children } = this.props;

    return children;

  }

}