var exec = require('cordova/exec');

exports.echo = function(arg0, success, error) {
    exec(success, error, "ModusEcho", "echo", [arg0]);
};

exports.echo2 = function (arg0, success, error) {
    exec(success, error, "ModusEcho", "echo2", [arg0]);
};

exports.androidcode = function (arg0, success, error) {
    exec(success, error, "ModusEcho", "androidcode", [arg0]);
};

exports.getZipFromAirportCode = function (arg0, success, error) {
    exec(success, error, "ModusEcho", "getZipFromAirportCode", [arg0]);
};

exports.echojs = function (arg0, success, error) {
    // Do something
    success(arg0);
};