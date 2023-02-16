import update from 'react-addons-update';


const TaskListReducer = (state = {}, action) => {

    if(action.type === "ADD_TASK"){

        return update(state, {$push: [action.payload]});
     
    }
    else if(action.type === "REMOVE_TASK"){
        return {
            ...state,
            list: state.list.filter(task => task.id !== action.payload)
       }
    }
    else if(action.type === "SET_TASK"){
        return update(state, {[action.payload.id]: {$set: [action.payload.value]}});
    }

    return state;
}

export default TaskListReducer;


