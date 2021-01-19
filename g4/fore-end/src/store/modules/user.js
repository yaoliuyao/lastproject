import *  as local from '../../utils/local'
export default {
    namespaced: true,
    state: {
        token: local.getToken(),
        userinfo: local.getUser()
    },
    mutations: {
        setToken(state, str) {
            state.token = str
            local.setToken(str)
        },
        setUserInfo(state, obj) {
            state.userinfo = obj
            local.setUser(obj)
        }
    }
}