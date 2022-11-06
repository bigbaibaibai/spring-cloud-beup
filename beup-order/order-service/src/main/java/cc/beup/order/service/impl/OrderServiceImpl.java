package cc.beup.order.service.impl;

import cc.beup.order.model.bo.OrderBO;
import cc.beup.order.service.OrderService;
import cc.beup.user.model.dto.UserDTO;
import cc.beup.user.provider.UserProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private UserProvider userProvider;

    @Override
    public OrderBO getOrder() {
        final OrderBO orderBO = new OrderBO();
        orderBO.setOrderName("测试订单");

        final UserDTO user = userProvider.getUser();
        orderBO.setUserName(user.getName());
        orderBO.setUserAge(user.getAge());
        return orderBO;
    }
}
