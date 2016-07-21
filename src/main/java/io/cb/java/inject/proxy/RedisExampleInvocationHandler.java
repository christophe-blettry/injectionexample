/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.proxy;

import io.cb.java.instrument.bean.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author Christophe Blettry (blech)
 */
public class RedisExampleInvocationHandler implements InvocationHandler {

	static {
		Context.loadResource("test/beans.xml");
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("getRedisConnection")){
			return Context.getResource("redisConnectionProxy");
		}
		throw new UnsupportedOperationException();
	}

}
