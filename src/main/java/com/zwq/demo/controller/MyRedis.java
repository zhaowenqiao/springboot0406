package com.zwq.demo.controller;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

public class MyRedis {

    public static void main(String[] args) {

//        Jedis jedis = new Jedis("localhost");
        /*JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

//        int inti = 0;
        new Thread(()->{
            Jedis jedis = pool.getResource();
            for (int j = 0;j<10;j++){
                    jedis.set("a" + j,String.valueOf(j));
                    System.out.println("a" + j +" is:" + jedis.get("a" + j));
            }
        }).start();

//        int intij = 1;
        new Thread(()->{
            Jedis jedis = pool.getResource();
            for (int j = 0;j<10;j++){
                jedis.set("b" + j,String.valueOf(j));
                System.out.println("b" + j +" is:" + jedis.get("b" + j));
            }
        }).start();
*/
    }
}
