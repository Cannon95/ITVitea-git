import { Link } from 'react-router-dom';

export default (props) => {
    const linkje = `/character/${props.index}`;

    return (
        <Link to={linkje}>
            <h2>{props.name}</h2>
            <p>{props.index}</p>
        </Link>
    )
}