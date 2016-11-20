var React = require('react');
var ReactDOM = require('react-dom');

/*
	App
	This will let us make <App/>
*/
var App = React.createClass({

	render: function() {
		return (
			<div className="catch-of-the-day">
				<div className="menu">
					<Header />
				</div>
				<Order />
				<Inventory />
			</div>
		)
	}
});

/*
	Header
	This will let us make <Header/>
*/
var Header = React.createClass({
	render: function() {
		return (
			<p>Header </p>
		)
	}
});

/*
	Order
	This will let us make <Order/>
*/
var Order = React.createClass({
	render: function() {
		return (
			<p>Order </p>
		)
	}
});

/*
	Inventory
	This will let us make <Inventory/>
*/
var Inventory = React.createClass({
	render: function() {
		return (
			<p>Inventory </p>
		)
	}
});


/*
	StorePicker
	This will let us make <StorePicker/>
*/
var StorePicker = React.createClass({

	render: function() {
		return (
			<form className="store-selector">
				<h2>Please Enter a Store</h2>
				<input type="text" ref="storeId" required />
				<input type="Submit" />
			</form>
		)
	}
});


ReactDOM.render(<App/>, document.querySelector('#main'));