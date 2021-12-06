import React, { Component, useState } from 'react'
import Axios from 'axios'
import "./Login.css";
export default function Login() {
    const[email,setEmail] = useState("")
    const[Password,setPassword] = useState("")

    const[loginStatus, setLoginStatus] = useState("")
    const login = () => {
        Axios.post('http://localhost:8081/api/user/login',{
            email:email,Password:Password
        }).then(
            (response) =>{


                if(response.data.message){
                    setLoginStatus(response.data.message)
                }else{
                    setLoginStatus(response.data[0].email)
                }
                //console.log(response.data);
            });
    }
    return (
        <div className="d-flex col text-center justify-content-center">
            <form className="form-signin ">
                <h1 className="h3 mb-3 mt-3 font-weight-normal"> Please sign in</h1>
                <label htmlFor="inputEmail" className="sr-only">
                    Email Address
                </label>
                <input
                    onChange={(e)=>setEmail(e.target.value)}
                    type="email" id="inputEmail" className="form-control" placeholder="Email Address" required autoFocus>
                </input>
                <label htmlFor="inputPassword" className="sr-only">
                    Password
                </label>
                <input
                    onChange={(e)=>setPassword(e.target.value)}
                    type="password" id="inputPassword" className="form-control" placeholder="Password" required>

                </input>
                <button onClick={login} className="btn btn-lg btn-primary btn-block m-3 " type="submit"> Log in </button>

                <h1> {loginStatus}</h1>

            </form>
        </div>
    )

}
