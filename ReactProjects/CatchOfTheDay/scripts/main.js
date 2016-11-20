var React = require('react');
var ReactDOM = require('react-dom');

var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var Navigation = ReactRouter.Navigation;
var History = ReactRouter.History;
var NotFoundRoute = ReactRouter.NotFoundRoute;

var createBrowserHistory = require('history/lib/createBrowserHistory');

var h = require('./helpers');

/*
	App
	This will let us make <App/>
*/
var App = React.createClass({
	getInitialState: function() {
		return {
			fishes: {},
			order: {}
		}
	},
	addToOrder: function(key) {
		this.state.order[key] = this.state.order[key] + 1 || 1;
		this.setState({order: this.state.order });
	},
	addFish: function(fish) {
		var timeStamp = (new Date()).getTime();

		this.state.fishes['fish-'+timeStamp] = fish;

		this.setState({ fishes: this.state.fishes });
	},
	loadSamples: function() {
	    this.setState({
	      fishes : require('./sample-fishes')
	    });
  	},
  	renderFish: function(key) {
  		return <Fish key={key} index={key} details={this.state.fishes[key]} addToOrder={this.addToOrder}/>
  	},
	render: function() {
		return (
			<div className="catch-of-the-day">
				<div className="menu">
					<Header tagline="Fresh Seafood Market" />
					<ul className="list-of-fishes">
						{Object.keys(this.state.fishes).map(this.renderFish)}
					</ul>
				</div>
				<Order />
				<Inventory addFish={this.addFish} loadSamples={this.loadSamples}/>
			</div>
		)
	}
});

/*
	Fish
	<Fish />
*/
var Fish = React.createClass({
	onButtonClick: function() {
		this.props.addToOrder(this.props.index);
	},
	render: function() {
		var details = this.props.details;
		var isAvaible = (details.status === 'available' ? true : false);
		var buttonText = (isAvaible ? 'Add To Order' : 'Sold Out');
		return (
			<li className="menu-fish">
				<img src={details.image} alt={details.name} />
				<h3 className="fish-name">
					{details.name}
					<span className="price">{h.formatPrice(details.price)}</span>
				</h3>
				<p>{details.desc}</p>
				<button disabled={!isAvaible} onClick={this.onButtonClick}>{buttonText}</button>
			</li>		
		)
	}
});


/*
	Add Fish Form
	<AddFishForm />
*/
var AddFishForm = React.createClass({
	createFish: function(event) {
		event.preventDefault();

		var fish = {
			name: this.refs.name.value,
			price: this.refs.price.value,
			status: this.refs.status.value,
			desc: this.refs.desc.value,
			image: this.refs.image.value
		}

		this.props.addFish(fish);
		this.refs.fishForm.reset();
	},
	render: function() {
		return (
			<form className="fish-edit" ref="fishForm" onSubmit={this.createFish}>
				<input type="text" ref="name" placeholder="Fish Name" />
				<input type="text" ref="price" placeholder="Fish Price" />
				<select ref="status">
					<option value="available">Fresh!</option>
					<option value="unavailable">Sold Out!</option>
				</select>
				<textarea type="text" ref="desc" placeholder="Desc" ></textarea>
				<input type="text" ref="image" placeholder="URL to image" />
				<button type="submit">+ Add Item</button>
			</form>
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
			<header className="top">
				<h1>Catch 
					<span className="ofThe">
						<span className="of">of</span>
						<span className="the">the</span>
					</span>
				Day</h1>
				<h3 className="tagline"><span>{this.props.tagline}</span></h3>
			</header>
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
			<h3>Order</h3>
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
			<div>
				<h2>Inventory</h2>
				<AddFishForm {...this.props} />	
				<button onClick={this.props.loadSamples}>Load Sample Fishes</button>
			</div>
		)
	}
});


/*
	StorePicker
	This will let us make <StorePicker/>
*/
var StorePicker = React.createClass({

	mixins: [History],
	goToStore: function(event) {
		event.preventDefault();
		// get the data from the input
		var storeId = this.refs.storeId.value;
		this.history.pushState(null, '/store/'+ storeId);
		// transition from <StorePicker /> to <App />

	},
	render: function() {
		return (
			<form className="store-selector" onSubmit={this.goToStore}>
				<h2>Please Enter a Store</h2>
				<input type="text" ref="storeId" defaultValue={h.getFunName()} required />
				<input type="Submit" />
			</form>
		)
	}
});

/*
	Not Found
*/
var NotFound = React.createClass({
	render: function() {
		return <h1>404 Not Found!</h1>
	}
});


/* 
	Routes
*/
var routes = (
	<Router history={createBrowserHistory()}>
		<Route path="/" component={StorePicker} />
		<Route path="/store/:storeId" component={App} />
		<Route path="*" component={NotFound} />
	</Router>

)


ReactDOM.render(routes, document.querySelector('#main'));