package com.wyj.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * public abstract ZuulFilter implements IZuulFilter{
 * abstract public String filterType();//过滤器类型，返回字符串代表过滤器的类型，
 * //包含：pre：请求在被路由之前执行（权限控制、限流、对请求进行解析）；routing：在路由请求时调用；post：在routing和errror过滤器之后调用；error：处理请求时发生错误调用
 * abstract public int filterOrder();//过滤器顺序,数字越大，优先级越低，负数最高
 * boolean shouldFilter();// 来自IZuulFilter，要不要过滤，返回true，当前过滤器生效
 * Object run() throws ZuulException;// IZuulFilter，过滤逻辑
 * }
 *
 * @author wyj
 * @create 2019-06-30 15:30
 */
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }

}
