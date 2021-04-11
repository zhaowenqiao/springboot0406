package com.zwq.demo.controller;

public class Mytest {

    public static void main(String[] args) {

        /*Jedis jedis = new Jedis("192.168.96.128");
        jedis.auth("6993258");
        jedis.set("food","food1");
        String food = jedis.get("food");
        System.out.println(food);*/
//        for  ( int  i =  1 ; i <=  100 ; i+=10) {
//            // 初始化CommentId索引 SortSet
//            jedis.zadd("topicId", i, "commentId"+i);
//            // 初始化Comment数据 Hash
//            jedis.hset("Comment_Key","commentId"+i, "comment content .......");
//        }
//        // 倒序取 从0条开始取 5条 Id 数据
////        Set<String> sets = jedis.zrangeByLex("topicId", "1", "80", 0, 5);
//        Set<Tuple> sets = jedis.zrevrangeByScoreWithScores("topicId", 5, 0);
//        String[] items = new String[]{};
//        System.out.println(sets.toString());
//        // 根据id取comment数据
//        List<String> list = jedis.hmget("Comment_Key", sets.toArray(items));
//        for(String str : list){
//            System.out.println(str);
//        }


//        String key = "serach";
////        jedis.zadd(key,0,"你");
////        jedis.zadd(key,1,"你们");
////        jedis.zadd(key,2,"你们好");
//        jedis.zadd(key,0,"你");
//        jedis.zadd(key,0,"你们");
//        jedis.zadd(key,0,"serach5");
//        jedis.zadd(key,0,"serach6");
//
//        Set<String> strings = jedis.zrangeByLex(key, "[你", "[你们",0,10);
//        System.out.println(strings);
//
////        Set<String> strings22 = jedis.zrangeByLex(key, "","",0,10);
////        System.out.println(strings22);
////        int inti = 0;
////        new Thread(()->{
////            for (int j = 0;j<10;j++){
////                    jedis.set("a" + inti,String.valueOf(inti));
////                    System.out.println("a" + inti +" is:" + jedis.get("a" + inti));
////            }
////        }).start();
////
////        int intij = 1;
////        new Thread(()->{
////            for (int j = 0;j<10;j++){
////                jedis.set("a" + intij,String.valueOf(intij));
////                System.out.println("a" + intij +" is:" + jedis.get("a" + intij));
////            }
////        }).start();

    }
}
