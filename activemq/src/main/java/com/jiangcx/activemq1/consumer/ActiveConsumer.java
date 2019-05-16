package com.jiangcx.activemq1.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ptp模式
 */
public class ActiveConsumer {

    public static void main(String[] args) throws JMSException {
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
        // 创建一个名为myQueue的消息队列
        Queue myQuene = session.createQueue("myQueue");

        // 创建消息消费者
        MessageConsumer consumer = session.createConsumer(myQuene);
        //接收消息
        TextMessage message = (TextMessage) consumer.receive();
        String msg = message.getText();
        System.out.println("消费者接收到的数据为：" + msg);
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
