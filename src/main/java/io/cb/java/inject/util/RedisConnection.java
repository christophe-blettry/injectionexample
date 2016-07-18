/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.util;

/**
 *
 * @author FR20173
 */
public class RedisConnection {

	private String host;
	private int port;
	private RedisPool pool;

	public RedisConnection() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public RedisPool getPool() {
		return pool;
	}

	public void setPool(RedisPool pool) {
		this.pool = pool;
	}

	@Override
	public String toString() {
		return "RedisConnection{" + "host=" + host + ", port=" + port + ", pool=" + pool + '}';
	}

}
