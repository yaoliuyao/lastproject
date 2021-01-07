export function typefilter(v) {
    let ret = "";
    switch (v) {
        case "t":
            ret = "投稿";
            break;
        case "s":
            ret = "失物招领";
            break;
        case "n":
            ret = "最新活动";
            break;
        case "h":
            ret = "话题";
            break;
    }
    return ret;
}