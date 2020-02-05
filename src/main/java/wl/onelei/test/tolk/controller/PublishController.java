package wl.onelei.test.tolk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: tolk
 * @Package: wl.onelei.test.tolk.controller
 * @ClassName: PublishController
 * @Author: Administrator
 * @Description: publish
 * @Date: 2020/2/5 21:58
 * @Version: 1.0
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
