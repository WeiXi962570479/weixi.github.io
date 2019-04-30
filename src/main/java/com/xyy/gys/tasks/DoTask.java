package com.xyy.gys.tasks;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 异步任务测试
 * @author WeiXi
 *
 */
@RestController
@RequestMapping("/task")
public class DoTask {
	
	@Autowired
	private AsyncTestTask asycnTask;
	
	@RequestMapping("/test")
	public String test() throws InterruptedException {
	long startTime = System.currentTimeMillis();
	
	Future<Boolean> task1 = asycnTask.doTask1();
	Future<Boolean> task2 = asycnTask.doTask2();
	Future<Boolean> task3 = asycnTask.doTask3();
	
	while(!task1.isDone() || !task2.isDone() || !task3.isDone()) {
		if(task1.isDone() && task2.isDone() && task3.isDone()) {
			break;
		}
	}
	
	long endTime = System.currentTimeMillis();
	String times = "任务全部完成，总耗时："+(endTime-startTime)+"毫秒";
	System.out.println(times);
	return times;
	}
	
}
