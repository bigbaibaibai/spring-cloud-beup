package cc.beup.user.provider;

import cc.beup.user.model.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserProvider {

    @GetMapping("/basic/getUser")
    UserDTO getUser();

}
