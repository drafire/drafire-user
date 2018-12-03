package com.drafire.user.jms;

import com.drafire.user.connection.ConnectionAddr;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activemq的发送方
 */
public class QueueSender {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://" + ConnectionAddr._128.getAddr() + ":61616");

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);  //设置为自动的ack

            //目的地
            Destination destination = session.createQueue("first-queue");

            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("hello word,drafire");
            producer.send(message);
            //session提交发送
            session.commit();
            //session关闭
            session.close();

            System.out.println("已经发送消息");
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
