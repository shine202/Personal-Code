var React = require('react');
var AppActions = require('../actions/AppActions');
var AppStore = require('../stores/AppStore');
var Contact =  require('./Contact.js');

var ContactList = React.createClass ({


    render: function(){

        return(
            <div>
                <h3>Contacts</h3>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.props.contacts.map(function(contact, index){
                                return(
                                    <Contact contact={contact} key={index} />
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        );
    }

});

module.exports = ContactList;
