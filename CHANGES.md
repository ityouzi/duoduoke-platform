# Release Notes
 

Requirements: **Java 8+** required


- redis 作为注册中心 关于登录密码问题.  
- 如果只设置了密码，没有设置用户名，就会抛Invalid url, password without username的异常。
- 如果redis有密码设置,连接注册中心时候,请一并填写 password ,username 属性,username 不能为空,随便填写一个值通过验证即可。 
- 详情查看dubbo源码 , org.apache.dubbo.common.URL 类中的
-                   构造方法: public URL(String protocol, String username, 
                            String password, String host, int port, String path, 
                            Map<String, String> parameters) 


 

