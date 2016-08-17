package cn.xiaoyu.test;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtNewMethod;
import javassist.Modifier;

public class TestJavassist {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass ctClass = pool.makeClass("cn.xiaoyu.JavassistClass");
		
		StringBuffer body = null;
		
		//设置属性
		CtField ctField = new CtField(pool.get("java.lang.String"),"name",ctClass);
		ctField.setModifiers(Modifier.PRIVATE);
		// getter setter方法
		ctClass.addMethod(CtNewMethod.setter("setName", ctField));
		ctClass.addMethod(CtNewMethod.setter("getName", ctField));
		ctClass.addField(ctField,Initializer.constant("default"));
		
		// 无参的构造函数
		CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
		body = new StringBuffer();
		body.append("{\n name=\"me\";\n}");
		ctConstructor.setBody(body.toString());
		ctClass.addConstructor(ctConstructor);
		
		//添加一个有参的构造函数
		ctConstructor = new CtConstructor(new CtClass[]{pool.get("java.lang.String")},ctClass);
		ctConstructor.setBody("{$0.name = $1;}");
		ctClass.addConstructor(ctConstructor);

		// 普通方法
		javassist.CtMethod ctMethod = new javassist.CtMethod(ctClass.voidType, "execute", new CtClass[]{}, ctClass);
		ctMethod.setModifiers(Modifier.PUBLIC);
		body = new StringBuffer();
		body.append("{\n System.out.println(name);");  
        body.append("\n System.out.println(\"execute ok\");");  
        body.append("\n return ;");  
        body.append("\n}"); 
        ctMethod.setBody(body.toString());
        ctClass.addMethod(ctMethod);
        
        Class<?> c = ctClass.toClass();
        Object obj = c.newInstance();
        Method method = obj.getClass().getMethod("execute", new Class[]{});
        method.invoke(obj, new Object[]{});
	}
}

 
