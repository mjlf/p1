package com.mjlf.rocketmq.base.batch.delay;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName Producer
 * @Author mjlft
 * @Date 2020/5/5 23:16
 * @Version 1.0
 * @Description 批量发送消息
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("base");
//        2.指定Nameserver地址
        producer.setNamesrvAddr("192.168.50.127:9876;192.168.50.26:9876");
//        3.启动producer
        producer.start();
//        4.创建消息对象，指定主题Topic、Tag和消息体
        Message message1 = new Message("test-mq", "base1", ("hello world" + 1).getBytes());
        Message message2 = new Message("test-mq", "base1", ("hello world" + 2).getBytes());
        Message message3 = new Message("test-mq", "base1", ("hello world" + 3).getBytes());
        //设置消息延迟发送
//            message.setDelayTimeLevel(2);
        List<Message> messages = new ArrayList<Message>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);


//        5.发送消息
        SplitIterator iterator = new SplitIterator(messages);
        while (iterator.hasNext()){
            List<Message> ms = iterator.next();
            SendResult result = producer.send(messages);
            System.out.println(result);
        }

//            TimeUnit.SECONDS.sleep(1);
//        6.关闭生产者producer
        producer.shutdown();
    }

    static class SplitIterator implements Iterator<List<Message>>{
        List<Message> messages;
        int index = 0;

        public SplitIterator(List<Message> messages) {
            this.messages = messages;
        }

        public boolean hasNext() {
            return this.index < messages.size();
        }

        public List<Message> next() {
            long sum = 0;
            if(hasNext()){
                List<Message> ms = new ArrayList<Message>();
                for(; index < messages.size();){
                    Message message = messages.get(index);
                    if(sum + message.getTopic().length() + message.getBody().length < 50){
                        System.out.println(index);
                        sum = sum + message.getTopic().length() + message.getBody().length;
                        ms.add(message);
                        index ++;
                    }else {
                        break;
                    }
                }
                return ms;
            }
            return null;
        }

        public void remove() {

        }
    }
}
