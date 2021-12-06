const express = require("express");
const mysql = require("mysql");
const cors = require("cors");

const app = express();
app.use(express.json());

app.use((cors));

app.use(express.static('public'));

const db = mysql.createConnection({
    user:"root",
    host:"localhost",
    password:"password",
    database: "microegg",
});

app.post('/api',(request, response) =>{

});

app.post('/api/user/signup',(reg,res)=>{

    const fname=reg.body.fname
    const lname=reg.body.lname
    const gender=reg.body.gender
    const mobile=reg.body.mobile
    const email=reg.body.email
    const Password=reg.body.Password
    db.query(
        "INSERT INTO Users (fname,lname,gender,mobile,email,Password) VALUES (?,?,?,?,?,?)",
        [fname,lname,gender,mobile,email,Password],(err, result)=>{
            console.log(err);
        });
});

app.post('/api/user/login',(req,res)=>{
    const email= reg.body.email
    const Password= reg.body.Password
    db.query(
        "SELECT * FROM Users WHERE email=? AND Password =?",
        [email,Password],
        (err, result)=> {
            if (err){
                res.send({err: err});
            }

            if (result.length>0){
                res.send(result);
            }else{
                res.send({message:"Wrong email/password"});
            }

        }
    );
});

app.listen(3000, () => {
    console.log("running on port 3000");
});