package com.xyy.gys.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.xyy.gys.pojo.ImoocJSONResult;
import com.xyy.gys.utils.JsonUtil;
/**
 * 拦截器
 * @author WeiXi
 *
 */
public class OneInterceptor implements HandlerInterceptor{
	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object) throws Exception {
		
		System.out.println("被one拦截，放行。。。");
		
		return true;
		
		/*if (true) {
			returnErrorResponse(response, IMoocJSONResult.errorMsg("被one拦截。。。"));
		}
		
		return false;*/
		
//		return HandlerInterceptor.super.preHandle(request, response, object);
	}
	
	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object, ModelAndView mv)
			throws Exception {
//		HandlerInterceptor.super.postHandle(request, response, object, mv);
	}
	
	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
	 * （主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object object, Exception ex)
			throws Exception {
//		HandlerInterceptor.super.afterCompletion(request, response, object, ex);
	}
	
	public void returnErrorResponse(HttpServletResponse response, ImoocJSONResult result) 
			throws IOException, UnsupportedEncodingException {
		OutputStream out=null;
		try{
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/json");
		    out = response.getOutputStream();
		    out.write(JsonUtil.objectToJson(result).getBytes("utf-8"));
		    out.flush();
		} finally{
		    if(out!=null){
		        out.close();
		    }
		}
	}
}
