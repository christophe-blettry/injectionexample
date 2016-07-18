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
public class RedisPool {

	public short number;
	public String using;

	public RedisPool() {
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		this.number = number;
	}

	public String getUsing() {
		return using;
	}

	public void setUsing(String using) {
		this.using = using;
	}

	@Override
	public String toString() {
		return "RedisPool{" + "number=" + number + ", using=" + using + '}';
	}

}
