window.app.register('dummy', function(app) {

    'use strict';

    var exports = {};

    var config = {
        
    };

    var showDummy = function(text){

        $('.sub-menu').hide();

        $('.dummy div').text(" Showing some dummy content for: " + text);
        $('.dummy').show();

        $('body').toggleClass('dummy-opened');

    };

    exports.show = function(text) {
        return showDummy(text);
    };

    exports.config = function(key, val) {
        config[key] = val;
    };

    return exports;

});