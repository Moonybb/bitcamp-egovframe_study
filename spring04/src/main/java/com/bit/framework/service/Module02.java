package com.bit.framework.service;

public class Module02 {
	//다형성
	ConsoleService console;

	//의존주입 (DI, Dependency Injection)
//	public Module02(ConsoleService console) {
//			super();
//			this.console = console;
//	}

	public void setConsole(ConsoleService console) {
		this.console = console;
	}
	
	public int func01(int a, int b) {
		console.sayHello();
		return 1234;
	}
	
	public void func02() {
		int[] arr= {1,3,5,7,9};
		for(int i=0; i<5; i++) {
			System.out.print(arr[i]+":");
			console.sayHi();
		}
//		int su = 1 / 0;
	}
}

