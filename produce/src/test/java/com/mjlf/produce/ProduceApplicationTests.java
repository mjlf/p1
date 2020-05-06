package com.mjlf.produce;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProduceApplicationTests {

    @Autowired
    private RocketMQTemplate rocketMqTemplate;

    @Test
    void contextLoads() {
        rocketMqTemplate.convertAndSend("test-mq", "hello springboot");
        log.info("消息发送成功");
    }

}
