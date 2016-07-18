/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.reflect;

import static io.cb.java.inject.MainAllTests.FORMAT;
import io.cb.java.inject.util.RedisConnection;
import io.cb.java.instrument.bean.Context;

/**
 *
 * @author FR20173
 */
public class RedisTestReflect {

	public RedisTestReflect() {
		Context.loadResource("test/beans.xml");
		RedisConnection redisConnection = Context.getResource("redisConnectionReflect");
		RedisExample redisExample = new RedisExample();
		redisExample.setRedisConnection(redisConnection);
		System.out.println(String.format(FORMAT, this.getClass().getName(), redisExample.getRedisConnection()));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		RedisTestReflect redisTestReflect = new RedisTestReflect();
	}

}