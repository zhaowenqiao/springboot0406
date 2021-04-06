package com.zwq.demo.controller;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

public class Mytest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        int inti = 0;
        new Thread(()->{
            for (int j = 0;j<10;j++){
                    jedis.set("a" + inti,String.valueOf(inti));
                    System.out.println("a" + inti +" is:" + jedis.get("a" + inti));
            }
        }).start();

        int intij = 1;
        new Thread(()->{
            for (int j = 0;j<10;j++){
                jedis.set("a" + intij,String.valueOf(intij));
                System.out.println("a" + intij +" is:" + jedis.get("a" + intij));
            }
        }).start();

    }
}
