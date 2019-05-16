package com.jiangcx.activemq2.provider;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveProvider {
    public static void main(String[] args) throws Exception{
        // 创建mq的连接工厂 ConnectionFactory，JMS用它来创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.1.102:61616");

        // 获得一个连接  客户端到JMS provider 的连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();
        // 创建一个session 参数说明 是否开启事务模式、签收模式
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        // 创建一个名为myTopic的主题
        Topic myTopic = session.createTopic("myTopic");
        // 创建消息生产者 MessageProducer
        MessageProducer producer = session.createProducer(myTopic);
        // 设置为不用持久化
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 创建一条消息
        TextMessage message = session.createTextMessage("消息内容为：你好activemq topic");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }

}
