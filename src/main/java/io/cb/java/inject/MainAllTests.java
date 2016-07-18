/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject;

import io.cb.java.inject.bytecode.RedisTestByteCode;
import io.cb.java.inject.proxy.RedisTestProxy;
import io.cb.java.inject.reflect.RedisTestReflect;

/**
 *
 * @author Christophe Blettry (blech)
 */
public class MainAllTests {

	public static final String FORMAT="%45.45s: %s";
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		System.out.println("By Reflection");
		RedisTestReflect redisTestReflect = new RedisTestReflect();
		System.out.println("========================================");
		System.out.println("By Proxy");
		RedisTestProxy redisTestProxy = new RedisTestProxy();
		System.out.println("========================================");
		System.out.println("By Agent -bytecode modification-");
		RedisTestByteCode RedisTestByteCode = new RedisTestByteCode();
	}

}
