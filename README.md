#The Injectors : example

see the instrumentation before.

[here the examples](https://github.com/christophe-blettry/injectionexample)

With a configuration file [beans.xml](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/resources/test/beans.xml), we will carry out the test of the 3 types of injections.

The example is to charge 2 beans  `RedisPool` and `RedisConnection` configured in the xml file and view these objects (`toString()`).
`RedisPool` is passed by reference to `RedisConnection`: *`<property name="pool" ref="redisPoolReflect"/>`*.

Each package contains one main file that can be executed.
You need to add the java `tools.jar` in your classpath, or to your maven repository.


- ####[Direct](https://github.com/christophe-blettry/injectionexample/tree/master/src/main/java/io/cb/java/inject/reflect)

In the package `io.cb.java.inject.reflect` we instantiate the `RedisConnection` object without making a `new` but using the reflection method see: `Context.getResource`

- ####[Method](https://github.com/christophe-blettry/injectionexample/tree/master/src/main/java/io/cb/java/inject/proxy)

In the package `io.cb.java.inject.proxy` the class `RedisExample` [\*](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/java/io/cb/java/inject/proxy/RedisExample.java) implement `getRedisConnection` from `RedisExampleInterface` [\*](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/java/io/cb/java/inject/proxy/RedisExampleInterface.java) .

In the `main` (`RedisTestProxy`[\*](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/java/io/cb/java/inject/proxy/RedisTestProxy.java)), we will proxify the interface *RedisExampleInterface* 

    `RedisExampleInterface redisExample = (RedisExampleInterface) Proxy.newProxyInstance(...)` 
via `RedisExampleInvocationHandler`[\*](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/java/io/cb/java/inject/proxy/RedisExampleInvocationHandler.java) : the implementation class of the interface `InvocationHandler`[\*](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/InvocationHandler.html) .

What will cause the interception of all calls to the interface methods. This implies that we will intercept calls to getRedisConnection, which will return the direct instantiation of RedisConnection`


*RedisExampleInvocationHandler*:


    @Override  
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
		if(method.getName().equals("getRedisConnection")){  
			return Context.getResource("redisConnectionProxy");  
		}  
		throw new UnsupportedOperationException();  
	}  


- ###[Constructor](https://github.com/christophe-blettry/injectionexample/tree/master/src/main/java/io/cb/java/inject/bytecode)

In the package `io.cb.java.inject.bytecode` we instantiate the `RedisConnection` object by transforming the bytecode of the `RedisExample` class.

Each class is proceed by the ClassTransformer.
We use @Inject and @Named annotation to retreive field that must be initialized during the instanciation of the object.
If we found @Inject annotation the class will be transformed.
The bytecode of the class will be transformed by adding in all existing constructor the code of field initialization (see `Transformer` [class](https://github.com/christophe-blettry/injectiontest/blob/master/src/main/java/io/cb/java/instrument/Transformer.java)):


    String line = "this." + ctField.getName() + "= (" + ctField.getType().getName() + ")io.cb.java.instrument.bean.Context.getResource(\"" + name + "\");";

With this added line of code the class will be "recompile" and outputed by the method.
From now on, it will be this new piece of byte code that will be used by the jvm.


- ###[Demo Output](https://github.com/christophe-blettry/injectionexample/blob/master/src/main/java/io/cb/java/inject/MainAllTests.java)


    By Reflection
       io.cb.java.inject.reflect.RedisTestReflect: RedisConnection{host=localhost, port=6379, pool=RedisPool{number=1, using=reflection}}
    By Proxy
       io.cb.java.inject.proxy.RedisTestProxy: RedisConnection{host=localhost, port=6389, pool=RedisPool{number=2, using=proxification}}
    By Agent -bytecode modification-
       io.cb.java.inject.bytecode.RedisTestByteCode: RedisConnection{host=localhost, port=6399, pool=RedisPool{number=3, using=bytecode modification (constructor)}}