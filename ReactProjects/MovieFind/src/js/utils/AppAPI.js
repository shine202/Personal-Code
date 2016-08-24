var AppActions = require('../actions/AppActions');

module.exports = {
    searchMovies: function(movie) {
        $.ajax({
            url: 'http://www.omdbapi.com/?s='
        })
    }
}