package cc.beup.user.provider.impl;

import cc.beup.user.model.bo.UserBO;
import cc.beup.user.service.UserService;
import cc.beup.user.model.dto.UserDTO;
import cc.beup.user.provider.UserProvider;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserProviderImpl implements UserProvider {

    @Resource
    private UserService userService;

    @Override
    public UserDTO getUser() {
        final UserBO user = userService.getUser();
        final UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        return userDTO;
    }

}
