package cn.xiaoyu.test;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class TestJavassistDemo {
	public static void main(String[] args) throws Exception {
		CtClass ctClass = ClassPool.getDefault().get("cn.xiaoyu.test.StringBuilder");
		addTiming(ctClass, "buildString");
		ctClass.writeFile("D:/");

		Class clazz = ctClass.toClass();
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("buildString", int.class);
		String result = (String) method.invoke(obj,3);
		System.out.println("result:"+result);		
	}

	public static void addTiming(CtClass clazz, String mname) throws Exception {
		CtMethod mold = clazz.getDeclaredMethod(mname);

		String nname = mname + "$impl";
		mold.setName(nname);
		CtMethod mnew = CtNewMethod.copy(mold, mname, clazz, null);

		String type = mold.getReturnType().getName();
		StringBuffer body = new StringBuffer();
		body.append("{\nlong start = System.currentTimeMillis();\n");
		// 接受返回值
		if (!"void".equals(type)) {
			body.append(type + " result = ");
		}
		body.append(nname + "($$);\n");
		body.append("System.out.println(\"Call to method " + mname
				+ " took \" +\n (System.currentTimeMillis()-start) +\" ms.\");\n");
		// 将返回值返回
		if (!"void".equals(type)) {
			body.append("return result;\n");
		}
		body.append("}");

		mnew.setBody(body.toString());
		clazz.addMethod(mnew);
	}
}

class StringBuilder {
	public String buildString(int length) throws Exception {
		String result = "";
		for (int i = 0; i < length; i++) {
			result += (char) (i % 26 + 'a');
		}
		Thread.sleep(100);
		return result;
	}
}