package wl.onelei.test.tolk.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.intercepter
 * @ClassName: WebConfig
 * @Author: Administrator
 * @Description:123
 * @Date: 2020/2/26 23:03
 * @Version: 1.0
 * @update:123
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * @Author: Administrator
     */

    @Autowired
    private SessionIntercepter sessionIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionIntercepter).addPathPatterns("/*");
    }
}
