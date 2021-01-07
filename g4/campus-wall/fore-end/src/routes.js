import VueRouter from "vue-router";
import Home from "./pages/Home";
import Post from "./pages/Post";

export default new VueRouter({
  routes: [
    {
      path: "/", component: Home
    },
    {
      path: "/post/:id", component: Post
    }
  ]
})
