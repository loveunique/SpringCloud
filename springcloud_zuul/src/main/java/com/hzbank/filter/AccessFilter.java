package com.hzbank.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由之前执行。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序。
     * 当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     * @return
     */
    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有请求都会生效。
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");

        if (token == null) {
            log.warn("token is empty");
            context.setSendZuulResponse(false);//令zuul过滤该请求，不对其进行路由
            context.setResponseStatusCode(401);//设置了其返回的错误码
            context.setResponseBody("No Auth,Token is Empty");//对返回body内容进行编辑
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
