package cc.beup.user.service.impl;

import cc.beup.user.model.bo.UserBO;
import cc.beup.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserBO getUser() {
        final UserBO userBO = new UserBO();
        userBO.setAge(24);
        userBO.setName("bai");
        return userBO;
    }
}
