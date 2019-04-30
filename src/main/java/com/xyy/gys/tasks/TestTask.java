package com.xyy.gys.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 定时任务
 * @author WeiXi
 *
 */
@Component
public class TestTask {
	
//	@Scheduled(fixedRate=3000)     //定义每过3秒运行
	@Scheduled(cron="0/3 * * 30 4 ?")              //cron表达式，springboot不支持年
	public void reportNowTime() {
		System.out.println("当前时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
