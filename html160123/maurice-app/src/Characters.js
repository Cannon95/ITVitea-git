import React from "react";
import Api from "./Api";
import CharacterSingle from "./CharacterSingle";



class characters extends React.Component {
    state = {
        characters: [],
    }

    componentDidMount() {

        const url = `https://swapi.dev/api/people/`;
        Api(url)
            .then(data => {
                console.log(data.results);
                this.setState({ characters: data.results });
            })
            .catch(error => console.log(error));

    }

    render() {
        return (
            <>
                <h1>characters</h1>
                {
                    this.state.characters.map((character, index) => 
                       <CharacterSingle
                            name={character.name}
                            key={index.toString()}
                            index={index+1}
                       />
                    )

                }
            </>

        );
    }
}

export default characters;


