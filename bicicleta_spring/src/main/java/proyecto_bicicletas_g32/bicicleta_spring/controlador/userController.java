package proyecto_bicicletas_g32.bicicleta_spring.controlador;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController
{
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal)
        {
            //return principal.getAttributes(); //NO SE RECOMIENDA PORQUE EXPONE DATOS PRIVADOS
            //Map<String, Object> VARIABLE = Collections.singletonMap("name", principal.getAttribute("Login"));
            
            return Collections.singletonMap("name", principal.getAttribute("name"));
        }
}
