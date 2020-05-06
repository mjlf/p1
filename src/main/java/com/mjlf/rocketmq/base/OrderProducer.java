package com.mjlf.rocketmq.base;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @ClassName Producer
 * @Author mjlft
 * @Date 2020/5/5 23:16
 * @Version 1.0
 * @Description 消息局部顺序
 */
public class OrderProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("base");
//        2.指定Nameserver地址
        producer.setNamesrvAddr("192.168.50.127:9876;192.168.50.26:9876");
//        3.启动producer
        producer.start();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
//        4.创建消息对象，指定主题Topic、Tag和消息体
                Message message = new Message("test-mq", "base1", ("hello world" + i + j).getBytes());
//        5.发送消息
                final int finalI = i;
                SendResult result = producer.send(message, new MessageQueueSelector() {
                    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                        return list.get(finalI % list.size());
                    }
                }, i);
                System.out.println(result);
            }

//            TimeUnit.SECONDS.sleep(1);
        }
//        6.关闭生产者producer
        producer.shutdown();
    }
}
