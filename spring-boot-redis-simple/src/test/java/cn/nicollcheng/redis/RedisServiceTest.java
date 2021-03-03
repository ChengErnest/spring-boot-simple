package cn.nicollcheng.redis;

import cn.nicollcheng.redis.util.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author nicollcheng
 * @Description
 * @data 2021/2/25
 */
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisService redisService;
    @Test
    public void test(){
        redisService.set("testKey", "value", 10);
        redisService.set("key1", "value");
        redisService.del("key1");
        redisService.set("num",2);
        redisService.decr("num", 1);
        redisService.incr("num", 2);
        redisService.expire("num", 10);
        redisService.hset("hkey","item","value");
        redisService.hget("hkey","item");
    }

}
