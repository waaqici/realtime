var express = require('express');
var router = express.Router();
var url = require('url');

/* GET users listing. */
router.get('/', function(req, res, next) {


    var queryData = url.parse(req.url, true).query;
    var mysql = require('mysql');

    var config ={
        host:'localhost',
        user:'root',
        password:'',
        database:'realTime'
    }
    var connection = mysql.createConnection(config);
    connection.connect();
    var a = "100";
var admin=615730747;
    var query = "insert into users (name,phone,pass,balance) values ('"+queryData.name+"','"+queryData.phone+"','"+queryData.pass+"','"+a+"')";


    connection.query(query, function (err,result) {

                var loginin = {msg: 'Your Account has Been Registered'}
                res.send(loginin);


    });


    connection.end();



});

module.exports = router;
