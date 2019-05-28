package xaau.xcj.Curriculum.resource.management.unit;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:55
 * @message:
 */
public class GetUrl {
    public static String getUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath(); // 获取项目名字
        String servletPat = request.getServletPath();// 获取servlet路径
        String queryString = request.getQueryString(); // 获取请求参数
        if (queryString != null) {
            if (queryString.contains("&cp=")) {
                int index = queryString.lastIndexOf("&cp=");
                queryString = queryString.substring(0, index);
            }
            return contextPath + servletPat + "?" + queryString;
        } else {
            return contextPath + servletPat + "?";
        }
    }
}
