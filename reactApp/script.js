
const title = React.createElement(
    'h1',
    { id: 'main-title', title: 'de Tietel', className: 'title'},
    'mijn eerste React Element'
);

const desc = React.createElement(
   'p',
   null,
   'beschrijving?!' 
);

const header = React.createElement(
    'header',
    null,
    title,
    desc
);

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(header);


