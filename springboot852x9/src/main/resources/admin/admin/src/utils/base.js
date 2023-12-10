const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot852x9/",
            name: "springboot852x9",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot852x9/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "尚业汽车租赁公司管理系统"
        } 
    }
}
export default base
