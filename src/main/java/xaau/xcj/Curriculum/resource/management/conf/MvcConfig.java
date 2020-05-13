package xaau.xcj.Curriculum.resource.management.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xaau.xcj.Curriculum.resource.management.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @program: Blog
 * @description:
 * @author: Mr.Xie
 * @create: 2020-05-13 22:03
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截器
        registry.addInterceptor(new SessionHandlerInterceptors())
                .excludePathPatterns("/static/**/**")
                .excludePathPatterns("/login.html","/index","/login","/register.html","/checkId","/regUser");
    }

    //静态资源处理
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        WebMvcConfigurer.super.addResourceHandlers(registry);


    }

    //格式化
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("YYYY-MM-dd HH:MM:SS"));
    }


}


//拦截器配置类
class SessionHandlerInterceptors implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

    //controller方法完成后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    //页面渲染结束运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}
