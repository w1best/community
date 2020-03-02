package wl.onelei.test.tolk.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wl.onelei.test.tolk.mapper.UserMapper;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.model.UserExample;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.intercepter
 * @ClassName: SessionIntercepter
 * @Author: Administrator
 * @Description:
 * @Date: 2020/2/26 23:14
 * @Version: 1.0
 */
@Component
public class SessionIntercepter implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie: cookies) {
                String name = cookie.getName();
                if("token".equals(name)){
                    String token = cookie.getValue();
                    UserExample example = new UserExample();
                    example.createCriteria()
                            .andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(example);
                    if (users.size() > 0){
                        request.getSession().setAttribute("user",users.get(0));
                    }
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
