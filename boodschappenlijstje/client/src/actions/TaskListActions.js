export function AddTask() {
    return {
        type: "ADD_TASK",
        payload: {
            name: "",
            checked: false
        }
    }
}

export function RemoveTask(pl) {
    return {
        type: "REMOVE_TASK",
        payload: pl
    }
}

export function SetTask(ID, val) {
    return {
        type: "Set_TASK",
        payload: {
            id:ID,
            value: val
        }
    }
}