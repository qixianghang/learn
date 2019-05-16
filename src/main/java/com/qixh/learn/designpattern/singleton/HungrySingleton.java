package com.qixh.learn.designpattern.singleton;

/**
 * 
 * @author qixh
 * @date 2019年5月16日
 *
 * 饿汉式：
 *   直接创建实例对象，不管你是否需要这个对象
 *   
 *   （1）构造器私有化
 *   （2）自行创建，并且用静态变量保存
 *   （3）向外提供这个实例
 *   （4）强调这是一个单例，我们可以用final修改
 */
public class HungrySingleton {
	private static final HungrySingleton INSTANCE = new HungrySingleton();
	
	private HungrySingleton() {
		
	}
	
	public static HungrySingleton getInstance() {
		return INSTANCE;
	}	
}
