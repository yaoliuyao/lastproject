import req from "../utils/request";

export default {
    /* 判断是否存在此用户 */
    checkUser(user) {
        return req({
            method: 'post',
            url: '/api/user/register/existence',
            data: user
        })
    },
    /*
    保存用户
     */
    saveUser(data) {
        return req({
            method: 'post',
            url: '/api/regedit/add',
            data: data
        })
    },
    registerEmail(data) {
        return req({
            mothod: 'post',
            url: 'api/regedit/register/email',
            data: data
        })
    }
}