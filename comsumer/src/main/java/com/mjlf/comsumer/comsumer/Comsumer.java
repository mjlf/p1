package com.mjlf.comsumer.comsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName Comsumer
 * @Author mjlft
 * @Date 2020/5/6 15:17
 * @Version 1.0
 * @Description TODO
 */
@Service
@RocketMQMessageListener(topic = "${demo.rocketmq.topic}", consumerGroup = "string_consumer", selectorExpression = "*")
@Slf4j
public class Comsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("消费到消息：" + s);
    }
}
