package cn.xiaoyu.test;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

public class JavassistLearn{  
    
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{  
        ProxyFactory factory=new ProxyFactory();  
        //设置父类，ProxyFactory将会动态生成一个类，继承该父类  
        factory.setSuperclass(TestJava.class);  
        //设置过滤器，判断哪些方法调用需要被拦截  
        factory.setFilter(new MethodFilter() {  
            public boolean isHandled(Method m) {  
                if(m.getName().equals("getName")){  
                    return true;  
                }  
                return false;  
            }  
        });  
        //设置拦截处理  
        factory.setHandler(new MethodHandler() {  
            public Object invoke(Object self, Method thisMethod, Method proceed,  
                    Object[] args) throws Throwable {  
                //拦截后前置处理，改写name属性的内容  
                //实际情况可根据需求修改  
            	TestJava o=(TestJava) self; 
            	System.out.println("方法执行前...");
            	o.setName("xiaoyu");
                Object obj = proceed.invoke(self, args);  
                System.out.println("方法执行后...");
                return obj;
            }  
        });  
          
        Class<?> c=factory.createClass();  
        TestJava object=(TestJava) c.newInstance();  
        System.out.println(object.getName());  
    }  
} 
class TestJava {
	private String name = "hello";

	public String getName() {
		System.out.println("getName方法Running...");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}