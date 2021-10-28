import React, { Component } from 'react'
import "./Login.css";
export default class Login extends Component {
    render() {
        return (
            <div className="d-flex col text-center justify-content-center">
                <form className="form-signin ">
                    <h1 className="h3 mb-3 mt-3 font-weight-normal"> Please sign in</h1>
                    <label for="inputEmail" className="sr-only">
                        Email Address
                    </label>
                    <input type="email" id="inputEmail" className="form-control" placeholder="Email Address" required autoFocus>
                    </input>
                    <label for="inputPassword" className="sr-only">
                        Password
                    </label>
                    <input type="email" id="inputPassword" className="form-control" placeholder="Password" required></input>
                    <button className="btn btn-lg btn-primary btn-block m-3 " type="submit"> Sign in </button>
                    <button className="btn btn-lg btn-primary btn-block m-3 " type="submit"> Sign up </button>

                    
                </form>
            </div>
        )
    }
}
