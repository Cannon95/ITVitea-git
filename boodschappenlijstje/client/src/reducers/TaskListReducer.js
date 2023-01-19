


const TaskListReducer = (state = {}, action) => {

    if(action.type === "ADD"){
        return {
             ...state,
             list: [action.payload, ...state.list]
        }
    }
    else if(action.type === "REMOVE"){
        return {
            ...state,
            list: state.list.filter(task => task.id !== action.payload.id)
       }
    }

    return state
}

export default TaskListReducer;


