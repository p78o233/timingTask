import Vue from 'vue';
import axios from 'axios';
import router from '../router';

axios.defaults.withCredentials = true;
axios.interceptors.response.use(function (response) {
    // Do something with response data
    console.log(response);
    localStorage.setItem("authorization", response.headers.authorization)
    checkData(response)
    return response;
}, function (error) {
    // Do something with response error
    return Promise.reject(error);
});
// const BASE_URL = 'http://192.168.50.229/mingya-backend/public/api/admin';
// const COMMON_URL = 'http://192.168.50.229/mingya-backend/public';
// 测试机
const BASE_URL = 'http://127.0.0.1:8301';
// const BASE_URL = 'http://10.1.161.102:20884';
const COMMON_URL = 'http://127.0.0.1:8301';
// 生产
// const BASE_URL = 'http://192.168.48.194:9090';
// const COMMON_URL = 'http://192.168.48.194:9090';
var flag = true;

function checkData(data) {
    if (data.data.code == 1) {
        return data.data
    } else if (data.data.code == 2) {
        Vue.prototype.$Message.error(data.data.msg);
        router.push('/login');
    } else {
        console.log(data.data)
        return data.data
        Vue.prototype.$Message.error(data.msg);
    }
}

/**
 * 封装get请求
 * @param url
 * @param params
 * @returns {Promise}
 */
function myGet(url, params) {
    return new Promise((resolve, reject) => {
        url = BASE_URL + url;
        axios.get(url, {
            params: params,
            headers: {
                authorization: localStorage.getItem("authorization")
            }
        })
            .then(res => {
                if(res.data.responseCode == '403'){
                    if(flag) {
                        flag = false
                        Vue.prototype.$Message.error('登陆信息失效,请重新登陆！');
                        setInterval(() => {
                            flag = true
                        }, 500)
                    }
                    router.push('/login');
                }else {
                    let data = checkData(res);
                    if (data !== false) {
                        resolve(data);
                    }
                }
            })
            .catch(err => {
                reject(err);


            })
    })
}

/**
 * 封装post请求
 * @param url
 * @param params
 * @returns {Promise}
 */
function myPost(url, params) {
    return new Promise((resolve, reject) => {
        url = BASE_URL + url;
        axios.post(url, params, {
        })
            .then(res => {
                    let data = checkData(res);
                    if (data !== false) {
                        resolve(data);
                    }
            })
            .catch(err => {
                if(flag) {
                    flag = false
                    Vue.prototype.$Message.error('登陆信息失效,请重新登陆！');
                    setInterval(() => {
                        flag = true
                    }, 500)

                }
                router.push('/login');
            })
    })
}

/**
 * 封装表单提交post请求
 * @param url
 * @param params
 * @returns {Promise}
 */
function myFormDataPost(url, formdata) {
    return new Promise((resolve, reject) => {
        url = BASE_URL + url;
        axios.post(url, formdata)
            .then(res => {
                let data = checkData(res);
                if (data !== false) {
                    resolve(data);
                }
            })
            .catch(err => {
                reject(err);
                console.log(err);
            })
    })
}

/**
 * 封装表单提交post请求
 * @param url
 * @param params
 * @returns {Promise}
 */
function myCommonPost(url, formdata) {
    return new Promise((resolve, reject) => {
        url = COMMON_URL + url;
        axios.get(url, formdata)
            .then(res => {
                let data = checkData(res);
                if (data !== false) {
                    resolve(data);
                }
            })
            .catch(err => {
                reject(err);
                console.log(err);
            })
    })
}

//首页接口
export const getRecentClick = params => {
    return myGet('/op/getRecentClick', params)
};
// mgr监视器接口
export const getAllMonitorIp = params => {
    return myGet('/getIpList', params)
};
export const getResoureInfo = params => {
    return myPost('/getResoureInfo', params)
}
export const setAndSendWarn = params => {
    return myPost('/setAndSendWarn', params)
}
export const getAppStatus = params => {
    return myPost('/getAppStatus', params)
}
// mgr登陆登出接口
export const mgrLogin = params => {
    return myPost('/login', params)
}
export const mgrLogout = params => {
    return myGet('/logout', params)
}
// mgr通用功能
export const getAllDubbo = params => {
    return myGet('/op/allDubbo', params)
};
export const allAction = params => {
    return myGet('/op/allAction', params)
};
export const actionCallback = params => {
    return myPost('/op/actionCallback', params)
}
export const delApp = params => {
    return myPost('/op/delApp', params)
}
// ===============================================================================================================
// 登陆接口
export const login = params =>{
    return myPost('/task/login',params)
}
// 获取自己当前状态的任务列表
export const getAllTaskByUserId = params => {
    return myGet('/task/getAllTaskByUserId', params)
};
// 保存定时任务
export const ioeTimeTask = params =>{
    return myPost("/task/ioeTimeTask",params)
}
// 删除定时任务
export const deleteTimeTask = params =>{
    return myPost("/task/deleteTimeTask",params)
}
//ee3f38cf88acecc5021c8eeab703caa5
