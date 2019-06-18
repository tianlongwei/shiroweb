# shiroweb
shiro与servlet

##web.xml的配置

>
    <listener>
        <listener-class>org.apache.shiro.web.env.EnvironmentLoaderListener</listener-class>
    </listener>
    
    <filter>
            <filter-name>shiroFilter</filter-name>
            <filter-class>org.apache.shiro.web.servlet.ShiroFilter</filter-class>
        </filter>
    <filter-mapping>
            <filter-name>shiroFilter</filter-name>
            <url-pattern>/*</url-pattern>
    </filter-mapping>
    

##EnvironmentLoaderListeners加载过程

1、在加载web.xml文件时，会先加载listener。执行listener的contextInitialized方法。servlet容器销毁时执行contextDestroyed

2、由于EnvironmentLoaderListeners继承了EnvironmentLoader并且在监听器初始化方法中调用了EnvironmentLoader的initEnvironment方法
因此，实际的处理逻辑在EnvironmentLoader中执行。

3、在initEnvironment方法中
    
    1、判断当前servlet容器中是否已经存在shiro环境。最终目的就是在当前的servlet容器中
    添加一个key为：org.apache.shiro.web.env.EnvironmentLoader.ENVIRONMENT_ATTRIBUTE_KEY 
    值为：org.apache.shiro.web.env.WebEnvironment的对象
    
4、当servlet容器中没有该shiroweb环境时，需要自己创建一个

    1、在创建WebEnvironment对象前，需要先确定其类型DefaultWebEnvironment或IniWebEnvironment
    2、首先从servlet容器中查找是否有key值为：shiroEnvironmentClass的初始化参数值，有的话直接返回该对象
    没有配置初始值就返回IniWebEnvironment.class（默认的）
    
5、在创建webEnvironment时，不管是默认的还是配置的。都会在servlet容器中获取key值为：shiroConfigLocations的初始化参数值作为配置信息

    1、如果初始化的配置信息有值，但是前面获取到的webEnvironment对象没有实现ResourceConfigurable接口。那么会抛出异常。无法为他添加配置信息
    2、 将当前servlet容器添加到webEnvironment属性中
    3、使用shiro的生命周期工具初始化webEnvironment对象。接下来都是调用各个webEnvironment接口实现类自己的方法了
    
6、IniWebEnvironment的初始化
    
    1、主要包括创建WebIniSecurityManagerFactory、ini配置文件加载
    2、 如果配置了shiro.ini的位置。就会从该位置加载ini配置文件内容
    3、如果自定义shiro.ini配置文件没有配置或配置后内容为空，则加载默认位置的shiro配置文件
    4、默认的shiro配置文件位置：/WEB-INF/shiro.ini和classpath:shiro.ini
    5、然后通过IniWebEnvironment构造器得到的factory和前面得到的ini配置文件创建WebSecurityManager
    
7、在创建的IniWebEnvironment对象中添加ini配置文件中获取的FilterChainResolver对象。
    
   
   
    
    
    