export function checkComment(str) {
    if (
        str.includes('nmb') ||
        str.includes('nmd') ||
        str.includes('cnm') ||
        str.includes('你妈逼') ||
        str.includes('你麻痹') ||
        str.includes('你妈比') ||
        str.includes('尼玛比') ||
        str.includes('尼玛币') ||
        str.includes('你妈的') ||
        str.includes('日你妈') ||
        str.includes('你妹的') ||
        str.includes('你大爷的') ||
        str.includes('你娘的') ||
        str.includes('日了') ||
        str.includes('垃圾') ||
        str.includes('菜鸡') ||
        str.includes('傻逼') ||
        str.includes('沙比') ||
        str.includes('煞笔') ||
        str.includes('沙雕') ||
        str.includes('傻掉') ||
        str.includes('啥比') ||
        str.includes('沙壁') ||
        str.includes('傻笔') ||
        str.includes('啥币') ||
        str.includes('nmsl') ||
        str.includes('caonima')
    ) {
        return true
    }
}