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
    connection.query("select * from users where phone = '"+queryData.phone+"' and pass = '"+queryData.pass+"'",
        function (err, rows, fields) {


            if (!err) {
                if (rows.length > 0) {
                    var loginin = {msg: 'Thanks Login Info is Correct'}
                    res.send(loginin);
                }
                else {
                    var error = {msg: 'User is Invalid'}
                    res.send(error);
                }
            }
            else {
                var error = {msg: 'error can not exceute query'}
                res.send(error);

            }

    });
    connection.end();



});

module.exports = router;
