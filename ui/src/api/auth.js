import request from "@/utils/request.js";
import router from "@/router/index.js";

export const login = (data)=>{
    request.post(`/login`, data).then(res=>{
        localStorage.setItem("Authorization", res.data.data)
        router.push({
            path: '/'
        })
    })
}

export const logout = ()=>{
    request.get(`/logout`).then(res=>{
        router.push({
            path: '/login'
        })
    })
}
