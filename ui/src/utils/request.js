import axios from 'axios'
import {error} from "@/utils/message.js";

const service = axios.create({
    baseURL: 'http://127.0.0.1:5050',
    timeout: 10000
})

service.interceptors.request.use(config => {
    if (getToken()) {
        config.headers.Authorization = getToken()
        return config;
    }
    return null;
})

service.interceptors.response.use(config=>{
    console.log(config.data)
    if(config.data.code != 200){
        console.log(1)
        error(config.data.msg)
        return null;
    }

    return config;
})

const getToken = () => {
    return localStorage.getItem("Authorization")
}

export default service

export const genQueryParam = (data) => {
    let params = "";
    for (var key in data) {
        params += key + "=" + data[key] + "&";
    }
    return params.substring(0, params.lastIndexOf("&"));
};
