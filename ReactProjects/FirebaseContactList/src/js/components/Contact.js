var React = require('react');
var AppActions = require('../actions/AppActions');
var AppStore = require('../stores/AppStore');


var Contact = React.createClass ({

    render: function(){

        return(
            <tr>
                <td>{this.props.contact.name}</td>
                <td>{this.props.contact.phone}</td>
                <td>{this.props.contact.email}</td>
                <td>
                    <a href="#" className="btn btn-default" onClick={this.handleEdit.bind(this, this.props.contact)}>Edit</a>
                    <a href="#" className="btn btn-danger" onClick={this.handleRemove.bind(this, this.props.contact.id)}>Delete</a>
                </td>
            </tr>
        );
    },

    handleRemove: function(i, j){
        console.log("Contact --> handleRemove");
        AppActions.removeContact(i);
    },

    handleEdit: function(i, j){
        console.log("Contact --> handleEdit");
        AppActions.editContact(i);
    }

});

module.exports = Contact;
