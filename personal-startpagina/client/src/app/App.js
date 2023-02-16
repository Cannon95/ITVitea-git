import '../index.css';
import Header from "./Header";
import Navigate from './Navigate';
import Main from './Main';

function App() {
  return (
    <div className="text-center w-screen h-screen">
      <div className="fixed h-screen w-screen bg-neutral-900"></div>{/* app-bg */}
      <Header/>
      <Navigate/>
      <div className="absolute left-5 sm:left-52 top-44 sm:top-24 font-bold text-xl text-neutral-400 decoration-red-900">Dashboard</div>
      <Main/>
    </div>
  );
}

export default App;
