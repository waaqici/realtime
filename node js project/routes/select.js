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
    connection.connect()

        connection.query("select user_id , ifnull((select sum(amount)+0 as rec from trans where `received_id` = '"+queryData.phone+"'),0) +(select sum(balance) from users where phone='"+queryData.phone+"') - ifnull((select sum(amount)+(0) as rec from trans where sender_id = '"+queryData.phone+"'),0) as balance from users  where phone='"+queryData.phone+"'", function (err, rows) {
            if (err){
                console.log(err);
                return;


            }
            rows.forEach(function (result) {
                console.log(result.balance);
                var loginin = {msg:result.balance}
                res.send(loginin);

            })

        });


        connection.end();


});

module.exports = router;





