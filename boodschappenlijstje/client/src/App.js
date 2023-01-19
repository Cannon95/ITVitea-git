import './App.css';
import AddTasks from './AppComps/AddTasks';
import Header from './AppComps/Header';
import TaskList from './AppComps/TaskList';
import { useState } from 'react';

function App() {
  const [taskList, setTaskList] = useState({});


  return (
    <>
      <div id="App">
        <Header />
        
        <div id="flexShow">
          
          <TaskList />
        </div>
        <AddTasks />

      </div>
      <div id="App-bg"></div>
    </>
  );
}

export default App;
