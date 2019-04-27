package com.xyy.gys.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import com.xyy.gys.pojo.ImoocJSONResult;

@RestControllerAdvice   // 全局异常类捕获
public class ExceptionHandlerAll {

//	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	/**
	 * web和ajax异常处理
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =Exception.class)
	public Object errorHandler(HttpServletRequest request, Exception e) throws Exception{
		e.printStackTrace();
		if(isAjax(request)) {
			return ImoocJSONResult.errorException(e.getMessage());
		}else {
			ModelAndView mView = new ModelAndView();
			mView.addObject("exception", e);
			mView.addObject("url", request.getRequestURL());
			mView.setViewName("teymeleaf/error");
			return mView;
		}

	}

	
	/**
	 * 判断是否是ajax请求
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {

		return request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString());

	}

}
