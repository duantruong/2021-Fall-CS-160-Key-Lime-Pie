const express = require('express');
const app = express();
app.use(express.static('public'));
const mysql = require("mysql");
const cors = require("cors");
app.use(express.json());
app.use(cors());
const db = mysql.createConnection({
    user: "root",
    host: "localhost",
    password: "sjsu-cs160",
    database:"duan",
});
app.post('/api',(request, response) =>{
   
});
app.post('/account-create',(reg, res)=>{
    const fname = reg.body.fname
    const lname = reg.body.lname
    const email = reg.body.email
    const password = reg.body.password
    db.query("INSERT INTO Users (fname, lname, email, password VALUES (?,?.?,?)",[firstname, lastname, email, password], (err, result)=>{
        console.log(err);
    })
});
app.listen(3002, () => {
    console.log("running on port 3002");
});