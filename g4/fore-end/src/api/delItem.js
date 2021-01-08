import req from '../utils/request'
export default {
    del(obj) {
        return req({
            method: 'delete',
            url: '/api/del',
            data: obj
        })
    }
}