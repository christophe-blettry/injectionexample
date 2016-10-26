/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.bytecode;

import io.cb.java.inject.util.RedisConnection;
import io.cb.java.injection.pojo.Inject;
import io.cb.java.injection.pojo.Named;

/**
 *
 * @author Christophe Blettry (blech)
 */
public class RedisExample {

	@Inject
	@Named("redisConnectionBytecode")
	RedisConnection redisConnection;

	public RedisExample() {
	}

	public RedisConnection getRedisConnection() {
		return redisConnection;
	}

	@Override
	public String toString() {
		return "RedisExample{" + "redisConnection=" + redisConnection + '}';
	}

}
