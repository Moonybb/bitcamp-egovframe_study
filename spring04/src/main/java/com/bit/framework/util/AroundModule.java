package com.bit.framework.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundModule implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
//		System.out.println("Around before");
//		invocation.proceed(); // 실행 기준
//		System.out.println("Around after");
//		return null;

		Object obj= null;
		System.out.println("Around(before)...");
		try {
			obj= invocation.proceed();
			System.out.println("Around(after)...");
		}catch(Exception e){
			System.out.println("Around(throw)...");
		}
		return obj;
	}
}