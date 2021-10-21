const express = require('express');
const app = express();
app.use(express.static('public'));

app.post('/api',(request, response) =>{
    
});

app.listen(3002, () => {
    console.log("running on port 3002");
});