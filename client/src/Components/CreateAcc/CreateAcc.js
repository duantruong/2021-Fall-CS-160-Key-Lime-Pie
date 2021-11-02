import React, { Component , useState} from 'react'
//import React, { useState } from "react";
import Axios from 'axios'
import "./CreateAcc.css";

export default function CreateAcc()  {
    const [fnameReg, setfnameReg] = useState ('')
    const [lnameReg, setlnameReg] = useState ('')
    const [emailReg, setEmailReg] = useState ('')
    const [passwordReg, setPasswordReg] = useState ('')
      
    const register = ()=>{
        Axios.post("http://localhost:3000/account-create",{
            fname: fnameReg, lname: lnameReg, email: emailReg, password: passwordReg,}).then((response)=>{
                console.log(response);
            });
    };
    
        return (
           
            <div className="d-flex col text-center justify-content-center">
                <form className="form-signin ">
                    <h1 className="h3 mb-3 mt-3 font-weight-normal"> Register for an account</h1>
                    <label for="inputEmail" className="sr-only">
                        First Name
                    </label>
                    <input type="fname" onChange={(e)=> {setfnameReg(e.target.value)}} id="inputFName" className="form-control" placeholder="First Name" required autoFocus>
                    </input>
                    <label for="inputEmail" className="sr-only">
                        Last Name
                    </label>
                    <input type="fname" onChange={(e)=> {setlnameReg(e.target.value)}} id="inputLName" className="form-control" placeholder="Last Name" required autoFocus>
                    </input>
                    <label for="inputEmail" className="sr-only">
                        Email Address
                    </label>
                    <input type="email" onChange={(e)=> {setEmailReg(e.target.value)}} id="inputEmail" className="form-control" placeholder="Email Address" required autoFocus>
                    </input>
                    <label for="inputPassword" className="sr-only">
                        Password
                    </label>
                    <input type="password" onChange={(e)=> {setPasswordReg(e.target.value)}} id="inputPassword" className="form-control" placeholder="Password" required></input>
                    <button onClick={register} className="btn btn-lg btn-primary btn-block m-3 " type="submit"> Sign up </button>

                    
                </form>
            </div>
        )
    
}
