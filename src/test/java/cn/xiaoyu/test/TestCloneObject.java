package cn.xiaoyu.test;

public class TestCloneObject {
	public static void main(String[] args) throws Exception {
		Person person = new Person("Roin", 22);
		Person per = (Person) person.clone();
		dealPerson(per);
		System.out.println(person.getName());
	}
	public static Person dealPerson(Person per){
		per.setName("xiaoyu");
		per.setAge(24);
		return per;
	}
}
