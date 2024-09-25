import request, {genQueryParam} from "@/utils/request.js";

export const load_all_verify = (data) => {
    return new Promise(r => {
        request.get(`/verify?${genQueryParam(data)}`).then(res => {
            r(res.data)
        })
    })
}

export const new_verify = (data) => {
    return new Promise(r => {
        request.post(`/verify`, data).then(res => {
            r(res)
        })
    })
}

export const change_verify = (data) => {
    return new Promise(r => {
        request.put('/verify', data).then(res => {
            r(res)
        })
    })
}

export const delete_verify = (id) =>{
    return new Promise(r=>{
        request.delete(`/verify?id=${id}`).then(res=>{
            r(res)
        })
    })
}
