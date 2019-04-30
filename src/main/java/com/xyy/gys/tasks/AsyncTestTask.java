package com.xyy.gys.tasks;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
/**
 * 异步任务
 * @author WeiXi
 *
 */
@Component
public class AsyncTestTask {
	
	@Async
	public Future<Boolean> doTask1() throws InterruptedException{
		long startTime = System.currentTimeMillis();
		Thread.sleep(3000);
		long endTime = System.currentTimeMillis();
		System.out.println("任务1耗时："+(endTime-startTime)+"毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
	@Async
	public Future<Boolean> doTask2() throws InterruptedException{
		long startTime = System.currentTimeMillis();
		Thread.sleep(8000);
		long endTime = System.currentTimeMillis();
		System.out.println("任务2耗时："+(endTime-startTime)+"毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
	@Async
	public Future<Boolean> doTask3() throws InterruptedException{
		long startTime = System.currentTimeMillis();
		Thread.sleep(5000);
		long endTime = System.currentTimeMillis();
		System.out.println("任务3耗时："+(endTime-startTime)+"毫秒");
		return new AsyncResult<Boolean>(true);
	}
	
}
