package cn.nicollcheng.redis.cluster;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
/**
 * @Author: nicollcheng
 * @CreateTime: 2021-3-3 11:01
 * @Description: 监听事件触发监听器
 */
@Slf4j
@Component
public class KeyExpiredEventMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String action = new String(message.getChannel());
        action = action.substring(action.indexOf(":")+1);
        String key = new String(message.getBody());
        log.info("监听到的键：{},监听到的事件：{}",key, action);
    }
}