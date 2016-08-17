package cn.xiaoyu.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class TestSingleton {
	public static void main(String[] args) throws Exception {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);

		// 1、利用反射入侵单例模式
		Class clazz = Class.forName("cn.xiaoyu.test.Singleton");
		Constructor constructor = clazz.getDeclaredConstructor(new Class[]{});
		constructor.setAccessible(true);
		Singleton instance = (Singleton) constructor.newInstance();
		System.out.println(instance);
		System.out.println("-------------------------");
		
		// 2、利用序列化入侵单例模式
		String filename = "D:/singleson.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(Singleton.getInstance());
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Singleton newInstance = (Singleton) ois.readObject();
		System.out.println(newInstance);
	}
}
class Singleton implements Serializable{
	private Singleton(){}
	public static Singleton singleton;
	public static Singleton getInstance(){
		if(singleton == null){
			synchronized(Singleton.class){
				if(singleton == null){
					singleton = new Singleton();
				}
			}
		} 
		return singleton;
	}
}