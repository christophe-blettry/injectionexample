/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.bytecode;

import static io.cb.java.inject.MainAllTests.FORMAT;
import io.cb.java.injection.Agent;
import io.cb.java.injection.pojo.Context;

/**
 *
 * @author Christophe Blettry (blech)
 */
public class RedisTestByteCode {

	static {
		Agent.initialize("--deBug");
		Context.loadResource("test/context.xml");
	}

	public RedisTestByteCode() {
		RedisExample redisExample = new RedisExample();
		System.out.println(String.format(FORMAT, this.getClass().getName(), redisExample.getRedisConnection()));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		RedisTestByteCode redisTestByteCode = new RedisTestByteCode();
	}

}
