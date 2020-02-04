package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.dto.AccessTokenDTO;
import wl.onelei.test.tolk.dto.GitHubUser;
import wl.onelei.test.tolk.mapper.UserMapper;
import wl.onelei.test.tolk.model.User;
import wl.onelei.test.tolk.provider.GitHubProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 *
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO tokenDTO = new AccessTokenDTO();
        tokenDTO.setClient_id(clientId);
        tokenDTO.setClient_secret(secret);
        tokenDTO.setCode(code);
        tokenDTO.setRedirect_uri(redirectUri);
        tokenDTO.setState(state);
        String gitHubToken = gitHubProvider.getAccessToken(tokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getUser(gitHubToken);
        System.out.println(gitHubUser.getName());
        if(gitHubUser != null){
            User user = new User();
            user.setName(gitHubUser.getName());
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertUser(user);
            response.addCookie(new Cookie("token",token));
//            request.getSession().setAttribute("user",gitHubUser);
            return "redirect:/";
        }else {
            return "redirect:/";
        }
    }
}
