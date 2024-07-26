package com.cleo.revision.vector_database;


import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Redis_Connect {

    public static void run() {
    try (UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379")) {

      Map<String, String> bike1 = new HashMap<>();
      bike1.put("model", "Deimos");
      bike1.put("brand", "Ergonom");
      bike1.put("type", "Enduro bikes");
      bike1.put("price", "4972");
      byte b = 0;
      var res2 = jedis.hmset("bike", bike1);
      System.out.println("HI:"+res2); // 4


      String res3 = jedis.hget("bike", "model");
      System.out.println(res3); // 4972

      Map<String, String> res4 = jedis.hgetAll("bike");
      System.out.println(res4); // {type=Enduro bikes, brand=Ergonom, price=4972, model=Deimos}


      List<String> res5 = jedis.hmget("bike", "model", "price");
      System.out.println(res5); // [Deimos, 4972]


      Long res6 = jedis.hincrBy("bike", "price", 100);
      System.out.println(res6); // 5072
      Long res7 = jedis.hincrBy("bike", "price", -100);
      System.out.println(res7); // 4972


      Long res8 = jedis.hincrBy("bike:stats", "rides", 1);
      System.out.println(res8); // 1
      Long res9 = jedis.hincrBy("bike:stats", "rides", 1);
      System.out.println(res9); // 2
      Long res10 = jedis.hincrBy("bike:stats", "rides", 1);
      System.out.println(res10); // 3
      Long res11 = jedis.hincrBy("bike:stats", "crashes", 1);
      System.out.println(res11); // 1
      Long res12 = jedis.hincrBy("bike:stats", "owners", 1);
      System.out.println(res12); // 1
      String res13 = jedis.hget("bike:stats", "rides");
      System.out.println(res13); // 3
      List<String> res14 = jedis.hmget("bike:stats", "crashes", "owners");
      System.out.println(res14); // [1, 1]

    }catch (JedisDataException e){
      System.out.println(e.getMessage());
    }
  }

    public static void main(String[] args) {
            //JedisPooled jedis = new JedisPooled("localhost", 6379);






/*

    UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");

    String status = jedis.set("bike:1", "Process 134");

    if ("OK".equals(status)) System.out.println("Successfully added a bike.");

    String value = jedis.get("bike:1");

    if (value != null) System.out.println("The name of the bike is: " + value + ".");


      Map<String, String> bike1 = new HashMap<>();
      bike1.put("model", "Deimos");
      bike1.put("brand", "Ergonom");
      bike1.put("type", "Enduro bikes");
      bike1.put("price", "4972");

      var res1 = jedis.hmset("bike:1", bike1);
      System.out.println(res1); // 4

      String res2 = jedis.hget("bike:1", "model");
      System.out.println(res2); // Deimos

      String res3 = jedis.hget("bike:1", "price");
      System.out.println(res3); // 4972

      Map<String, String> res4 = jedis.hgetAll("bike:1");
      System.out.println(res4); // {type=Enduro bikes, brand=Ergonom, price=4972, model=Deimos}


      List<String> res5 = jedis.hmget("bike:1", "model", "price");
      System.out.println(res5); // [Deimos, 4972]


      Long res6 = jedis.hincrBy("bike:1", "price", 100);
      System.out.println(res6); // 5072
      Long res7 = jedis.hincrBy("bike:1", "price", -100);
      System.out.println(res7); // 4972


      Long res8 = jedis.hincrBy("bike:1:stats", "rides", 1);
      System.out.println(res8); // 1
      Long res9 = jedis.hincrBy("bike:1:stats", "rides", 1);
      System.out.println(res9); // 2
      Long res10 = jedis.hincrBy("bike:1:stats", "rides", 1);
      System.out.println(res10); // 3
      Long res11 = jedis.hincrBy("bike:1:stats", "crashes", 1);
      System.out.println(res11); // 1
      Long res12 = jedis.hincrBy("bike:1:stats", "owners", 1);
      System.out.println(res12); // 1
      String res13 = jedis.hget("bike:1:stats", "rides");
      System.out.println(res13); // 3
      List<String> res14 = jedis.hmget("bike:1:stats", "crashes", "owners");
      System.out.println(res14); // [1, 1]
*/
      run();

    }




  }






