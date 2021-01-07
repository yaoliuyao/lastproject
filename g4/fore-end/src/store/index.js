import Vue from "vue";
import Vuex from "vuex";
import user from './modules/user'
import searchdata from './modules/searchdata'
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    searchdata
  }
});
