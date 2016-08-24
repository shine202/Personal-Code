import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import QuestionList from './quiz/QuestionList.jsx';
import Results from './quiz/Results.jsx';
//import Result from './quiz/Result.jsx';
import Scorebox from './quiz/Scorebox.jsx';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            questions: [
                {
                    id: 1,
                    text: 'What is your name?',
                    choices: [
                        {
                            id: 'a',
                            text: 'Michael'
                        },
                        {
                            id: 'b',
                            text: 'Brad'
                        },
                        {
                            id: 'c',
                            text: 'Shine'
                        }
                    ],
                    correct: 'c'
                },
                {
                    id: 2,
                    text: 'What is your mothers name?',
                    choices: [
                        {
                            id: 'a',
                            text: 'Luljeta'
                        },
                        {
                            id: 'b',
                            text: 'Sara'
                        },
                        {
                            id: 'c',
                            text: 'Sue'
                        }
                    ],
                    correct: 'a'
                },
                {
                    id: 3,
                    text: 'What is your fathers name?',
                    choices: [
                        {
                            id: 'a',
                            text: 'Bobby'
                        },
                        {
                            id: 'b',
                            text: 'Shkelzen'
                        },
                        {
                            id: 'c',
                            text: 'Wayne'
                        }
                    ],
                    correct: 'b'
                },
                {
                    id: 4,
                    text: 'What is your best friends name?',
                    choices: [
                        {
                            id: 'a',
                            text: 'Besar'
                        },
                        {
                            id: 'b',
                            text: 'Veton'
                        },
                        {
                            id: 'c',
                            text: 'Fatjon'
                        }
                    ],
                    correct: 'c'
                }
            ],
            score: 0,
            current: 1
        };
    }

    setCurrent(current) {
        this.setState({current});
    }


    setScore(score) {
        this.setState({score});
    }

    render() {
        if(this.state.current > this.state.questions.length) {
            var scorebox = '';
            var result = <Results {...this.state} />
        }
        else {
            var scorebox = <Scorebox {...this.state} />
            var result = '';
        }

        return (
            <div>
                {scorebox}
                <QuestionList {...this.state}
                    setCurrent={this.setCurrent.bind(this)}
                    setScore={this.setScore.bind(this)}  />

                {result}
            </div>

        )
    }
}

export default App