import Vue from 'vue'
import Popup from '../components/bounce/popup.vue'

const PopupBox = Vue.extend(Popup)

Popup.install = function (data) {
  let instance = new PopupBox({
    data
  }).$mount()

  document.body.appendChild(instance.$el)

  Vue.nextTick(() => {
    instance.show = true
    // show 和弹窗组件里的show对应，用于控制显隐
  })
}

export default Popup