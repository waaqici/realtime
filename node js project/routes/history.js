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
    var nom = queryData.received_id;

    connection.query("select   `trans_id` ,`received_id` , `sender_id`,`date`,`amount`, IF(received_id='"+nom+"', 'Revieved', 'Sent') as Status from trans where received_id='"+nom+"' or sender_id='"+nom+"'", function (err, rows) {
        if (err) {
            console.log(err);
            return;
        }else{
            var loginin = {msg:rows}
            res.send(loginin);


        }






    });


    connection.end();


});

module.exports = router;





