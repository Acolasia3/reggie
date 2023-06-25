package tao;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author 彭桂涛
 * @version 1.0
 */
//使用Jedis操作Redis
public class JedisTest {
    @Test
    public void testRedis(){
        //1.获取连接
        Jedis jedis = new Jedis("192.168.200.144",6379);
        jedis.auth("123456");
        //2.执行操作
        jedis.set("username","tao");
        String username = jedis.get("username");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        
        //3.关闭连接
        jedis.close();
    }
}
