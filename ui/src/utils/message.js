import {message} from "ant-design-vue";

export const clear_all = ()=>{
    message.destroy()
}

export const success = (msg)=>{
    clear_all()
    message.success(msg)
}

export const warn = (msg)=>{
    clear_all()
    message.warning(msg)
}

export const error = (msg)=>{
    clear_all()
    message.error(msg)
}

export const info = (msg)=>{
    clear_all()
    message.info(msg)
}
