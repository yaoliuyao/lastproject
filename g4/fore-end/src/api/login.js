import req from "../utils/request";

export default {
    /*
    获取用户
     */
    getuser(data) {
        return req({
            method: 'post',
            url: '/api/user/login',
            data: data
        })
    },
    /* 判断是否存在此用户 */
    checkUser(user) {
        return req({
            method: 'post',
            url: '/api/user/register/existence',
            data: user
        })
    },
    /* 根据token获取用户信息 */
    getUserInfo(token) {
        return req({
            method: 'get',
            url: `/api/user/login/info/${token}`,
        })
    }
}