package cc.beup.starter.web.intercepter;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试使用
 *
 * @author Bai Xinxiang
 * @since 2022/11/7 11:36
 */
public class RequestLogHandlerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(RequestLogHandlerInterceptor.class);

    private static final String REQUEST_START_TIME_KEY = RequestLogHandlerInterceptor.class.getName() + ":REQUEST_START_TIME_KEY";

    private static final String REQUEST_START_LOG_FORMAT = "\n==================================接口调用======================================"
            + "\n请求接口地址：     {}"
            + "\n请求IP：          {}";

    private static final String REQUEST_END_LOG_FORMAT = "\n请求总耗时：  {}毫秒"
            + "\n==============================================================================";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(REQUEST_START_TIME_KEY, System.currentTimeMillis());
        final Gson gson = new Gson();
        log.info(REQUEST_START_LOG_FORMAT, request.getRequestURL(), request.getRemoteAddr());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long requestStartTime = (long) request.getAttribute(REQUEST_START_TIME_KEY);
        log.info(REQUEST_END_LOG_FORMAT, System.currentTimeMillis() - requestStartTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
