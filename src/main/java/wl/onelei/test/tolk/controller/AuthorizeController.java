package wl.onelei.test.tolk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wl.onelei.test.tolk.dto.AccessTokenDTO;
import wl.onelei.test.tolk.dto.GitHubUser;
import wl.onelei.test.tolk.provider.GitHubProvider;

/**
 *
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO tokenDTO = new AccessTokenDTO();
        tokenDTO.setClient_id(clientId);
        tokenDTO.setClient_secret(secret);
        tokenDTO.setCode(code);
        tokenDTO.setRedirect_uri(redirectUri);
        tokenDTO.setState(state);
        String token = gitHubProvider.getAccessToken(tokenDTO);
        GitHubUser user = gitHubProvider.getUser(token);
        System.out.println(user.getName());
        return "index";
    }
}
