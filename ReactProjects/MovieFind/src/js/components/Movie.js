var React = require('react');
var AppActions = require('../actions/AppActions');
var AppStore = require('../stores/AppStore');

var Movie = React.createClass({
    render: function() {
        return(
            <div className="well">
                {this.props.movie.Title}
            </div>
        )
    },
});

module.exports = Movie;
