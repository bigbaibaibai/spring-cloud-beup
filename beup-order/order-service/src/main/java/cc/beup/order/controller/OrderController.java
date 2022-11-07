package cc.beup.order.controller;

import cc.beup.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/get")
    @GetMapping("/get")
    public Object getOrder() {
        return orderService.getOrder();
    }

}
