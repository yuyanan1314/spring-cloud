//package com.zuul;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//
//
//@Component
//public class TokenFilter extends ZuulFilter{
//
//	//判断过滤器是否生效
//	@Override
//	public boolean shouldFilter() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	//拦截业务逻辑
//	@Override
//	public Object run() throws ZuulException {
//		//拦截所有服务接口 判断服务接口上是否有传递userToken参数
//		
//		//1获取上下文
//		RequestContext currentContext = RequestContext.getCurrentContext();
//		//2获取request
//		HttpServletRequest request = currentContext.getRequest();
//		//3从header获取请求头
//		String token = request.getParameter("token");
//		if (StringUtils.isEmpty(token)) {
//			//直接响应 拒绝
//			currentContext.setSendZuulResponse(false);
//			currentContext.setResponseBody("userToken is null");
//			currentContext.setResponseStatusCode(401);
//		}
//		//正常执行
//		return null;
//	}
//
//	//过滤类型 
//	@Override
//	public String filterType() {
//		// TODO Auto-generated method stub
//		return "pre";
//	}
//
//	//过滤器执行的顺序 当一个请求在同一阶段存在多个过滤器的时候 多个过滤器执行顺序
//	@Override
//	public int filterOrder() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}
