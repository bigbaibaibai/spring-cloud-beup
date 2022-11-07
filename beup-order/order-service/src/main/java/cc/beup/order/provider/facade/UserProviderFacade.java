package cc.beup.order.provider.facade;

import cc.beup.user.model.dto.UserDTO;
import cc.beup.user.provider.UserProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserProviderFacade {

    @Resource
    private UserProvider userProvider;

    public UserDTO getUser() {
        return userProvider.getUser();
    }

}