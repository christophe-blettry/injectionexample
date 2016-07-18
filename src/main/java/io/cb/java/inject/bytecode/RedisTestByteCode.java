/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.bytecode;

import static io.cb.java.inject.MainAllTests.FORMAT;
import io.cb.java.instrument.Agent;
import io.cb.java.instrument.bean.Context;

/**
 *
 * @author FR20173
 */
public class RedisTestByteCode {

	static {
		Agent.initialize("--deBug");
	}

	public RedisTestByteCode() {
		Context.loadResource("test/beans.xml");
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