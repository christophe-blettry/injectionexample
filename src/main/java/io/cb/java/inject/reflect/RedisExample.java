/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.reflect;

import io.cb.java.inject.util.RedisConnection;

/**
 *
 * @author FR20173
 */
public class RedisExample {

	RedisConnection redisConnection;

	public RedisExample() {
	}

	public RedisConnection getRedisConnection() {
		return redisConnection;
	}

	public void setRedisConnection(RedisConnection redisConnection) {
		this.redisConnection = redisConnection;
	}

	@Override
	public String toString() {
		return "RedisExample{" + "redisConnection=" + redisConnection + '}';
	}

}
