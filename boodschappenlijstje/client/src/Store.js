import { combineReducers, configureStore } from '@reduxjs/toolkit'
import  TaskListReducer  from "./reducers/TaskListReducer";

const reducers = combineReducers({
  taskListReducer: TaskListReducer
})

export default configureStore({
  reducer: reducers
})