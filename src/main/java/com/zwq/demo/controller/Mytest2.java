package com.zwq.demo.controller;

import java.util.Set;

public class Mytest2 {

    public static void main(String[] args) {

        /*Jedis jedis = new Jedis("localhost");
        for  ( int  i =  1 ; i <  10 ; i++) {
            // 初始化CommentId索引 SortSet
            jedis.zadd("topicId", i+100, "commentId的具体内容:"+i);
            // 初始化Comment数据 Hash的value可以存成json对象 具体问题具体分析
//            jedis.hset("Comment_Key","commentId"+i, "commentId的具体内容:"+i);
        }*/

        //顺序取  id  (pageSize - 1)*10 到 (pageSize - 1)*10 + 9
        /*Set<String> sets = jedis.zrevrange("topicId", 0, 3);
        for(String item : sets){
            System.out.println(item);
        }
//        Set<String> sets = jedis.zrangeByScore("topicId", "1", "5", 0, 5);
        String[] items = new String[]{};*/
//        System.out.println(sets.toString());

        // 根据id取comment数据
//        List<String> list = jedis.hmget("Comment_Key", sets.toArray(items));
//        for(String str : list){
//            System.out.println(str);
//        }
//        jedis.del("topicId","Comment_Key");
    }
}
