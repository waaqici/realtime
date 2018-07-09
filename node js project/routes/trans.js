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
    var a = new Date();
    var resu;
    var logini;
    var resul;
    var p1=queryData.sender_id;
    var p2=queryData.received_id;



    connection.query("select * from users where phone = '"+queryData.sender_id+"'", function (err, rows) {
        if (err){
            console.log(err);
            return;


        }
        rows.forEach(function (result) {
            console.log(result.balance);
            var x = queryData.amount;
            var y = result.balance;

            resu = y-x;



        })

    });

    connection.query("select * from users where phone = '"+queryData.received_id+"'", function (err, rows) {
        if (err){
            console.log(err);
            return;


        }
        rows.forEach(function (result1) {
            console.log(result1.balance);
            var x = queryData.amount;
            var y1 = result1.balance;

             resul = +y1 + +x;




        })

    });



    var query = "insert into trans (received_id,sender_id,amount,date) values ('"+queryData.received_id+"','"+queryData.sender_id+"','"+queryData.amount+"','"+a+"')";


    connection.query(query, function (err,results) {

        var query = "update users set balance ='"+resul+"'where phone='"+p2+"'";
        logini = {msg:resul}
        res.send(logini);


    });

    connection.end();



});

module.exports = router;






