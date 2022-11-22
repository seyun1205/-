import axios from 'axios'

let base = '';

//传送JSON格式的post请求
export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params
    });
}

export const putRequest = (url,params) => {
    return axios({
        method: 'put',
        url: `${base}${url}`,
        data: params
    })
}

export const getRequest = (url,params) => {
    return axios({
        method: 'get',
        url: `${base}${url}`,
        data: params
    })
}

export const deleteRequest = (url,params) => {
    return axios({
        method: 'delete',
        url: `${base}${url}`,
        data: params
    })
}