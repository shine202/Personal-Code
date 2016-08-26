var AppDispatcher =  require('../dispatcher/AppDispatcher');
var AppConstants = require('../constants/AppConstants');
var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
var AppAPI = require('../utils/AppAPI.js');

var CHANGE_EVENT = 'change';

var _contacts = [];
var _contact_to_edit = '';

var AppStore = assign({}, EventEmitter.prototype, {

    getContacts: function(){
        return _contacts;
    },
    saveContact: function(contact){
        _contacts.push(contact);
    },
    setContacts: function(contacts){
        _contacts = contacts;
    },
    removeContact: function(contactId){

        console.log("AppStore --> removeContact");

        var index = _contacts.findIndex(x => x.id === contactId);
        _contacts.splice(index, 1);
    },
    setContactToEdit: function(contact){
        _contact_to_edit = contact;
    },
    getContactToEdit: function(){
        return _contact_to_edit;
    },
    updateContact: function(contact){
        for(i=0; i< _contacts.length; i++){
            if(_contacts[i].id == contact.id){
                _contacts.splice(i, 1);
                _contacts.push(contact);
            }
        }
    },
    emitChange: function(){
        this.emit(CHANGE_EVENT);
    },
    addChangeListener: function(callback){
        this.on('change', callback);
    },
    removeChangeListener: function(callback){
        this.removeListener('change', callback);
    }
});


AppDispatcher.register(function(payload){

    console.log("AppStore");

    var action = payload.action;

    switch(action.actionType){

        case AppConstants.SAVE_CONTACT:
            console.log('Saving Contact...');

            // Store Save
            AppStore.saveContact(action.contact);

            // Save to API
            AppAPI.saveContact(action.contact);

            // Emit change
            AppStore.emit(CHANGE_EVENT);
            break;


        case AppConstants.RECEIVE_CONTACTS:
            console.log('Receiving Contacts...');

            // Store Save
            AppStore.setContacts(action.contacts);


            // Emit change
            AppStore.emit(CHANGE_EVENT);
            break;

        case AppConstants.REMOVE_CONTACT:
            console.log('Removing Contacts...');

            // Store Remove
            AppStore.removeContact(action.contactId);

            // API Remove
            AppAPI.removeContact(action.contactId);


            // Emit change
            AppStore.emit(CHANGE_EVENT);
            break;


        case AppConstants.EDIT_CONTACT:
            console.log('Editing Contacts...');

            // Store Edit
            AppStore.setContactToEdit(action.contact);

            // Emit change
            AppStore.emit(CHANGE_EVENT);
            break;

        case AppConstants.UPDATE_CONTACT:
            console.log('Updating Contacts...');

            // Store Update
            AppStore.updateContact(action.contact);

            // API Update
            AppAPI.updateContact(action.contact);


            // Emit change
            AppStore.emit(CHANGE_EVENT);
            break;


    }

    return true;
});


module.exports = AppStore;
