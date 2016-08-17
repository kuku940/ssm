package cn.xiaoyu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;

public class TestSerializable {
	public static void main(String[] args) throws Exception {
		//serializable();// 序列化Person对象
		Person p = (Person) deSerializable();// 反序列Perons对象
		System.out.println(MessageFormat.format("name={0},age={1}", p.getName(), p.getAge()));
		System.out.println(MessageFormat.format("i={0},i={1}", p.i, p.j));		
	}

	public static void serializable() throws Exception {
		Person per = new Person("Roin", 24);
		per.i = 20;
		// ObjectOutputStream对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:/Person.txt")));
		oo.writeObject(per);
		System.out.println("Person对象序列化成功！");
		oo.close();
	}

	public static Object deSerializable() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/Person.txt")));
		Person person = (Person) ois.readObject();
		System.out.println("Person对象反序列化成功！");
		ois.close();
		return person;
	}
}

class Person implements Serializable,Cloneable {
	private static final long serialVersionUID = 1L;
	public static int i = 10;
	public transient int j = 20;
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}