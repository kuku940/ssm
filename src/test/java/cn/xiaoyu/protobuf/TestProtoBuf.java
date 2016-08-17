package cn.xiaoyu.protobuf;

import cn.xiaoyu.protobuf.Person.TestBuf;
import cn.xiaoyu.protobuf.Person.TestBuf.Builder;

public class TestProtoBuf {
	public static void main(String[] args) throws Exception {
		// 序列化
		Builder builder = Person.TestBuf.newBuilder();
		builder.setName("小雨");
		builder.setAge(22);
		builder.setNum(1);
		
		TestBuf buf = builder.build();
		byte[] byteArray = buf.toByteArray();
		
		//反序列化
		TestBuf test = TestBuf.parseFrom(byteArray);
		System.out.println(test.getName());
		System.out.println(test.getAge());
		System.out.println(test.getNum());
	}
}
