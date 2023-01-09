const desc = 'I just learned how to create a description';
const first_name = 'mark';

const header =
 <header>
    <h1 id='title'>{first_name}'s first element!</h1>
    <p>{desc}</p>
    <input type="text" value={10*20} />
</header>

const root = ReactDOM.createRoot(document.getElementById("root"));

const players = [
    {
        name: "Mark",
        initCount: 50,
        id: 1
    },
    {
        name: "Piet",
        initCount: 20,
        id: 2
    },
    {
        name: "Klaas",
        initCount: -18,
        id: 3
    }
]


const Counter = (props) => {
    return (
        <div className="counter">
            <button className="counter-action decrement"> - </button>
            <span className="counter-score">{props.value}</span>
            <button className="counter-action increment"> + </button>
        </div>
       
    )
}

const Header = (props) => {
    return (
        <header id="test">
            <h1 className={props.title}></h1>
            <span className="stats">Players: {props.totalPlayers}</span>
        </header>
    )
}

const Player = (props) => {
    return (
        <div className="player">
            <span className="player-name">{props.name}</span>
            <Counter value={props.initCount}/>
        </div>
    )
}

const App = () => {
    return (
        <div className="scoreboard">
            <Header title="scoreboard" totalPlayers={players.length}/>
            {players.map(player => 
                    <Player
                    name={player.name}
                    initCount={player.initCount}
                    key={player.id.toString()}
                    />
                )
            }
        </div>
    )
}

root.render(<App/>);