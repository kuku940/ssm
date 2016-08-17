package cn.xiaoyu.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 测试一些反射类的方法
 * @author roin_zhang
 */
public class TestReflect {
	public static void main(String[] args) throws Exception {
		Class<ReflectDemo> clazz = (Class<ReflectDemo>) Class.forName("cn.xiaoyu.test.ReflectDemo");
		
		System.out.println("---------------------------");
		// 获取有参的构造方法
		Constructor<ReflectDemo> constructor = clazz.getConstructor(int.class);
		System.out.println(constructor);
		
		System.out.println("---------------------------");
		// 获取公有构造函数
		Constructor<?>[] constructors = clazz.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
		
		System.out.println("---------------------------");
		// 可以获取私有的构造方法
		constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor);
		
		System.out.println("---------------------------");
		// 获取所有的构造方法  包括私有的方法
		constructors = clazz.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}
		
		constructor = clazz.getConstructor(String.class,int.class);
		ReflectDemo demo = constructor.newInstance("xiaoyu",22);
		
		Method method = clazz.getMethod("getName");
		System.out.println(method.invoke(demo));
		
	}
}

class ReflectDemo{
	private String name;
	private int age;
	public ReflectDemo(){}
	public ReflectDemo(int age){
		this.age = age;
	}
	public ReflectDemo(String name,int age){
		this.name = name;
		this.age = age;
	}
	private ReflectDemo(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int getAge() {
		return age;
	}
	private void setAge(int age) {
		this.age = age;
	}
	
}
