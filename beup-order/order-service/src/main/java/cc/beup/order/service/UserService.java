package cc.beup.order.service;

import cc.beup.user.provider.UserProvider;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user", url = "localhost:10010")
public interface UserService extends UserProvider {
}
