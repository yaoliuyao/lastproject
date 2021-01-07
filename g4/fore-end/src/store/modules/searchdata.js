export default {
    namespaced: true,
    state: {
        query: null,

    },
    mutations: {
        setQuery(state, str) {
            state.query = str
            // console.log('addData')
        }
    }
}