package com.drafire.user.jms;

import com.drafire.user.connection.ConnectionAddr;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activemq topic 模式的生产者
 */
public class TopicSender {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://" + ConnectionAddr._128.getAddr() + ":61616");
        Connection connection = null;
        try {
            connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createTopic("first-topic");
            MessageProducer producer = session.createProducer(destination);

            for (int i = 0; i < 5; i++) {
                TextMessage message = session.createTextMessage("hello,drafire" + i);
                producer.send(message);
            }

            session.commit();
            session.close();
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
