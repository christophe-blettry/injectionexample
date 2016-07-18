/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cb.java.inject.proxy;

import io.cb.java.inject.util.RedisConnection;

/**
 *
 * @author Christophe Blettry (blech)
 */
public interface RedisExampleInterface {

	public RedisConnection getRedisConnection();
}
