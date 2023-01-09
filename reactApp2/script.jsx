const Header = () => {
    return (
        <header>
            <div id="title">Ranked: <strong>top<br></br>5 cities</strong><br></br> of the world!</div>
        </header>
    )
}

const Cities = [
    {
        name: "Amsterdam",
        img: "fournullfour.png",
        country: "Holland",
        residents: "17000000",
        famousFor: "Anne Frank",
        key: 1
    },
    {
        name: "Berlin",
        img: "fournullfour.png",
        country: "Holland",
        residents: "17000000",
        famousFor: "Anne Frank",
        key: 2
        
    },
    {
        name: "Rome",
        img: "fournullfour.png",
        country: "Holland",
        residents: "17000000",
        famousFor: "Anne Frank",
        key: 3
    },
    {
        name: "Rio de Jeneiro",
        img: "fournullfour.png",
        country: "Holland",
        residents: "17000000",
        famousFor: "Anne Frank",
        key: 4
    },
    {
        name: "New York",
        img: "fournullfour.png",
        country: "Holland",
        residents: "17000000",
        famousFor: "Anne Frank",
        key: 5
    }
    
]

const City = props => {
    return (
        <div className="city" id={props.name}>
            <img src={props.img} alt="404" />
            <h2>{props.name}</h2>
            <p><strong>Country: </strong>{props.country}</p>
            <p><strong>Residents: </strong>{props.residents}</p>
            <p><strong>Famous for: </strong>{props.famousFor}</p>
        </div>
    )
}

const Section = () => {
    return (
        <section>
            {Cities.map(city =>
            <City 
                name={city.name}
                img={city.img}
                country={city.country}
                residents={city.residents}
                famousFor={city.famousFor}
                key={city.key}
            /> 
            )}
        </section>
    )
}


const App = () => {
    return (
        <div id="app">
            <Header />
            <Section />
        </div>
    )

}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
