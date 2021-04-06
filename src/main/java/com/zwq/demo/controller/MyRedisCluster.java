package com.zwq.demo.controller;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class MyRedisCluster {

    public static void main(String[] args) {
//        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//        //Jedis Cluster will attempt to discover cluster nodes automatically
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));
//        JedisCluster jc = new JedisCluster(jedisClusterNodes);

        Jedis jc = new Jedis("192.168.96.128",6379);
        String set = jc.set("foo", "bar");
        System.out.println(set);
        String value = jc.get("foo");
        System.out.println(value);

    }
}
