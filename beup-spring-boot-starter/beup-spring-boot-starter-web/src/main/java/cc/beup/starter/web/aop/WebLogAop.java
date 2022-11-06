package cc.beup.starter.web.aop;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class WebLogAop {

    private static final Logger log = LoggerFactory.getLogger(WebLogAop.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(* cc.beup.*..*(..))")
    public void controllerLog() {
    }

    @Around(value = "controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        final Gson gson = new Gson();
        long startTime = System.currentTimeMillis();
        // 获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 执行目标方法
        log.info("==================================接口调用======================================");
        String urlStr = request.getRequestURL().toString();
        log.info("请求接口地址：{}", urlStr);
        log.info("请求参数：{}", gson.toJson(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.info("请求返回结果：{}", gson.toJson(result));
        log.info("请求总耗时：{}毫秒", (System.currentTimeMillis() - startTime));
        log.info("==============================================================================");
        return result;
    }

}
