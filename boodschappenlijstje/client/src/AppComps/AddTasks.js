import "./Header.css"
import store from "../Store"
import { AddTask } from "../actions/TaskListActions"

const add_task = () => {
    
    add2List = () => {
        store.dispatch(AddTask());
    }

    return (
        <div id="addTask">
            <div id="addTask-text">Taak toevoegen:</div>
            <div id="addTask-logo" onClick={() => add2List()}>
                <img src="AddTask.png" alt="404" width="30" height="30"/>
            </div>
        </div>
    );
}

export default add_task;