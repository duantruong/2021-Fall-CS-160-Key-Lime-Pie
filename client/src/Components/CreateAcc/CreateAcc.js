import React, { Component, useState } from 'react'
import Axios from 'axios'

export default function CreateAcc() {
    const[fnameReg,setFnameReg] = useState("")
    const[lnameReg,setLnameReg] = useState("")
    const[genderReg,setGenderReg] = useState("")
    const[mobileReg,setMobileReg] = useState("")
    const[emailReg,setEmailReg] = useState("")
    const[PasswordReg,setPasswordReg] = useState("")

    const register = () => {
        Axios.post("http://localhost:8081/api/user/signup",{
            fname: fnameReg,
            lname : lnameReg,
            gender: genderReg,
            mobile: mobileReg,
            email:emailReg,
            Password:PasswordReg,
        }).then((response) =>{
            console.log(response);
        });
    };
    /*const handleClick=(e)=> {
        e.preventDefault()
        const User = {fname, lname, gender, mobile, email, password}
        console.log(User)
        fetch("http://localhost:8081/api/user/signup", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(User)
        }).then(() => {
            console.log("New account has been added")
        })
    }*/
    //render() {
    return (
        <div className="d-flex col text-center justify-content-center">
            <form className="form-signin ">

                <h1 className="h3 mb-3 mt-3 font-weight-normal"> Sign Up</h1>
                <label htmlFor="inputFirstName" className="sr-only">
                    First Name
                </label>
                <input
                    value={fnameReg}
                    onChange={(e) => setFnameReg(e.target.value)}
                    type="first-name" id="fname" className="form-control" placeholder="First Name" required autoFocus>
                </input>
                <label htmlFor="inputLastName" className="sr-only">
                    Last Name
                </label>
                <input
                    value={lnameReg}
                    onChange={(e) => setLnameReg(e.target.value)}
                    type="last-name" id="lname" className="form-control" placeholder="Last Name" required autoFocus>
                </input>
                <label htmlFor="inputLastName" className="sr-only">
                    Gender
                </label>
                <input
                    value={genderReg}
                    onChange={(e) => setGenderReg(e.target.value)}
                    type="last-name" id="gender" className="form-control" placeholder="Gender" required autoFocus>
                </input>
                <label htmlFor="inputLastName" className="sr-only">
                    Mobile
                </label>
                <input
                    value={mobileReg}
                    onChange={(e) => setMobileReg(e.target.value)}
                    type="last-name" id="mobile" className="form-control" placeholder="Mobile" required autoFocus>
                </input>

                <label htmlFor="inputEmail" className="sr-only">
                    Email
                </label>
                <input
                    value={emailReg}
                    onChange={(e) => setEmailReg(e.target.value)}
                    type="email" id="email" className="form-control" placeholder="Email Address" required>

                </input>

                <label htmlFor="inputPassword" className="sr-only">
                    Password
                </label>
                <input
                    value={PasswordReg}
                    onChange={(e) => setPasswordReg(e.target.value)}
                    type="password" id="Password" className="form-control" placeholder="Password" required
                    autoFocus>
                </input>

                <button className="btn btn-lg btn-primary btn-block m-3 " type="submit"  onClick={register}> Sign up

                </button>


            </form>
        </div>
    )
    //}
}
