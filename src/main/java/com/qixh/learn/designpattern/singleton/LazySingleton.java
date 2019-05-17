package com.qixh.learn.designpattern.singleton;

/**
 * 
 * @author qixh
 * @date 2019年5月17日
 *
 **懒汉式单例：
 **  通过静态内部类实现延迟加载、线程安全和性能问题
 **  (1)在内部类被加载和初始化时，才创建INSTANCE实例对象
 **  (2)静态内部类不会自动随着外部类的加载和初始化而初始化，只有在使用时才加载和初始化
 **  (3)因为是在内部类加载和初始化时，创建的，因此是线程安全的
 */
public class LazySingleton {
	private static boolean initialized = false;
	
	//静态的内部类（寄生虫）,解决多线程安全问题
    private static class LazyHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
	private LazySingleton() {
		//解决反射破坏到单例
		synchronized (LazySingleton.class) {
			if (!initialized) {
				initialized = true;
			} else {
				throw new RuntimeException("禁止初始化...");
			}
		}
	}
	
	public static LazySingleton getInstance() {
		return LazyHolder.INSTANCE;
	}
}
