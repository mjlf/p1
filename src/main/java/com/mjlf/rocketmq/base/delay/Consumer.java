package com.mjlf.rocketmq.base.delay;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @ClassName Consumer
 * @Author mjlft
 * @Date 2020/5/5 23:37
 * @Version 1.0
 * @Description 局部顺序消费
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
//        1.创建消费者Consumer，制定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
//        2.指定Nameserver地址
        consumer.setNamesrvAddr("192.168.50.127:9876;192.168.50.26:9876");
//        3.订阅主题Topic和Tag
        consumer.subscribe("test-mq", "base1");
//        设置广播模式消费
//        consumer.setMessageModel(MessageModel.BROADCASTING);

//        设置负载均衡消息
        consumer.setMessageModel(MessageModel.CLUSTERING);
//        4.设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println("【" + Thread.currentThread().getName() + "】" + new String(messageExt.getBody()) + " ： " + (System.currentTimeMillis() - messageExt.getStoreTimestamp()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

//        5.启动消费者consumer
        consumer.start();
    }
}
