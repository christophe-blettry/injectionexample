/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.proxy;

import static io.cb.java.inject.MainAllTests.FORMAT;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @author FR20173
 */
public class RedisTestProxy {

	public RedisTestProxy() {
		InvocationHandler redisExampleHandler = new RedisExampleInvocationHandler();
		RedisExampleInterface redisExample = (RedisExampleInterface) Proxy.newProxyInstance(
				RedisExampleInterface.class.getClassLoader(),
				new Class[]{RedisExampleInterface.class},
				redisExampleHandler);

		System.out.println(String.format(FORMAT, this.getClass().getName(), redisExample.getRedisConnection()));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		RedisTestProxy redisTestProxy = new RedisTestProxy();

	}

}
