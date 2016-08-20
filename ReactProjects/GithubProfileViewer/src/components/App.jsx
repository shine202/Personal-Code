import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import Profile from './github/Profile.jsx';

class App extends Component {
	constructor(props) {
		super(props);
		this.state = {
			username: 'Shkelqim1410',
			userData: [],
			userRepos: [],
			perPage: 5
		}
	}

	// Get user data from github
	getUserData() {
		$.ajax({
			url: 'https://api.github.com/users/'+this.state.username+'?client_id='+this.props.clientId+'&clien_secret'+this.props.clientSecret,
			dataType: 'json',
			cache: false,
			success: function(data){
				this.setState({userData: data});
				console.log(data);
			}.bind(this),
			error: function(xhr, status, error) {
				this.setState({username: null});
				alert(error);
			}.bind(this)
		});
	}

	componentDidMount() {
	    this.getUserData();  
	}

	render() {
		return (
			<div>
				<Profile userData = {this.state.userData}/>
			</div>
		)
	}
}

App.propTypes = {
    clientId: React.PropTypes.string,
    clientSecret: React.PropTypes.string
};

App.defaultProps = {
	clientId: '4eb5f83d4c97eecbd0b9',
	clientSecret: '7c71c480bc87fbf31fc87590e723e41ff09558b8'
}

export default App