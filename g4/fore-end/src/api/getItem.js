import req from '../utils/request'
export default {
    getdata() {
        return req({
            method: 'post',
            url: '/api/item'
        })
    },
    getUserName(u) {
        return req({
            method: 'post',
            url: '/api/getuser',
            data: u
        })
    }
}