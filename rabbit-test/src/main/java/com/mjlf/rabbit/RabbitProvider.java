package com.mjlf.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName RabbitProvider
 * @Author mjlft
 * @Date 2020/5/9 23:52
 * @Version 1.0
 * @Description rabbit 第一个生产者
 */
public class RabbitProvider {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1创建连接
        ConnectionFactory factory = new ConnectionFactory();
        //2设置交换器
        factory.setHost("172.21.39.15");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("root");

        Connection connection = factory.newConnection();
        connection.addShutdownListener(new ShutdownListener() {
            @Override
            public void shutdownCompleted(ShutdownSignalException e) {
                System.out.println("关闭连接");
            }
        });
        Channel channel = connection.createChannel();
        //设置mandantory和immadiate的时候， 如果找不到绑定或者交换器时，那么就会调用这个监听
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("返回结果：" + new String(body));
            }
        });
        channel.addReturnListener(new ReturnCallback() {
            @Override
            public void handle(Return returnMessage) {
                System.out.println("返回信息" + returnMessage.getReplyText());
            }
        });

        Map<String, Object> arg = new HashMap<String, Object>();
        arg.put("a1ternate-exchange", "exchange-direct1");
        //3.设置一个类型为direct, 持久化，非自动删除的交换器, 同时添加一个备份交换器
        channel.exchangeDeclare("exchange-direct-dlx", "direct", true, false, arg);
        //设置队列名称 非排他 非自动删除，
        //使用ttl需要注意队列之前是否存在， 之前是否设置了ttl
        Map<String, Object> argsss = new HashMap<String, Object>();
        argsss.put("x-message-ttl", 6000);
        argsss.put("vhost", "/");
        argsss.put("username","guest");
        argsss.put("password", "guest");
        argsss.put("x-max-priority", 10);

        //添加死信队列交换器
        argsss.put("x-dead-letter-exchange", "dead-exchange");
        //添加死信队列路由key
        argsss.put("x-dead-letter-routing-key", "routing-key1");

        channel.queueDeclare("queue-direct-ttl-dlx", true, false, false, argsss);
        //队列， 交换器， routing-key绑定
        channel.queueBind("queue-direct-ttl-dlx", "exchange-direct-dlx", "routing-key");

        //备份交换器
        channel.exchangeDeclare("dead-exchange", "direct", true, false, null);
        //设置队列名称 非排他 非自动删除，
        channel.queueDeclare("queue.d1x", true, false, false, null);
        //队列， 交换器， routing-key绑定
        channel.queueBind("queue.d1x", "dead-exchange", "routing-key1");

        String message = "hello world";
        //推送消息
        while (true){
            channel.basicPublish("exchange-direct-dlx",
                    "routing-key",
//                    true,
//                    false,
                    new AMQP.BasicProperties().builder().expiration("6000").priority(5).build(),
                    message.getBytes());
//            TimeUnit.SECONDS.sleep(1);
            TimeUnit.MICROSECONDS.sleep(30);
        }


//        channel.close();

//        connection.close();
        //4.队列绑定
        //5.生成消息
        //6.推送消息
        //7.关闭通道
        //8.关闭连接
    }
}
