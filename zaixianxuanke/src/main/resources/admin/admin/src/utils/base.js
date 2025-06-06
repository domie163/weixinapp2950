const base = {
    get() {
        return {
            url : "http://localhost:8080/zaixianxuanke/",
            name: "zaixianxuanke",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zaixianxuanke/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "在线选课系统"
        } 
    }
}
export default base
