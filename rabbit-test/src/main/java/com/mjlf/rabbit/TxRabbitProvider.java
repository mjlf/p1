package com.mjlf.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName RabbitProvider
 * @Author mjlft
 * @Date 2020/5/9 23:52
 * @Version 1.0
 * @Description rabbit 事务测试
 */
public class TxRabbitProvider {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1创建连接
        ConnectionFactory factory = new ConnectionFactory();
        //2设置交换器
        factory.setHost("192.168.50.85");
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


        channel.exchangeDeclare("exchange-direct-tx", "direct", true, false, null);
        channel.queueDeclare("queue-direct-tx", true, false, false, null);
        //队列， 交换器， routing-key绑定
        channel.queueBind("queue-direct-tx", "exchange-direct-tx", "routing-key");


        String message = "hello world";
        //开启confirm模式
        channel.confirmSelect();
        if(!channel.waitForConfirms()){
            //发送信息失败
        }
        //推送消息
        while (true) {
            //开启事务
            channel.txSelect();
            channel.basicPublish("exchange-direct-tx",
                    "routing-key",
//                    true,
//                    false,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes());
            if(System.currentTimeMillis() % 2 == 0){
                throw new ExportException("");
            }
            //事务提交
            channel.txCommit();
            TimeUnit.SECONDS.sleep(1);
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
