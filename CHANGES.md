# Release Notes
 

Requirements: **Java 8+** required


- redis 作为注册中心 不支持带密码.  
- 如果只设置了密码，没有设置用户名，就会抛Invalid url, password without username的异常。
- 详情查看dubbo源码 , org.apache.dubbo.common.URL 类中的
-                   构造方法: public URL(String protocol, String username, 
                            String password, String host, int port, String path, 
                            Map<String, String> parameters) 


 

