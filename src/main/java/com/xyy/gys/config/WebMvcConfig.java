package com.xyy.gys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xyy.gys.interceptor.OneInterceptor;
import com.xyy.gys.interceptor.TwoInterceptor;
/**
 * 注册器，注册拦截器
 * @author WeiXi
 *
 */
@Configuration      //表明当前是个适配器
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按顺序执行，可以配置多个url
		 */
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/user/**");
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/th/**").addPathPatterns("/user/**");
		
		super.addInterceptors(registry);
	}
	
}
