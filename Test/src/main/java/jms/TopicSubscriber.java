package jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicSubscriber implements MessageListener {
  public static Boolean TRANSACTIONAL = false;
  public static String TOPIC_NAME = "firstTopic";

  public static void main(String[] args) throws JMSException {
 /*   String host = args[0];
    String port = args[1];  */
	  String host="192.168.42.41";
	  String port="61616";
    // Creating Factory for connection
    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
        "tcp://" + host + ":" + port);
    Connection connection = factory.createConnection();
    // Setting unique client id for durable subscriber
    connection.setClientID("MyListener");
    connection.start();
    // Create 3 new consumers for the topic
    for (int i = 1; i <= 3; i++) {
      Session session = connection.createSession(TRANSACTIONAL,
          Session.AUTO_ACKNOWLEDGE);
      Topic destination = session.createTopic(TOPIC_NAME);
      MessageConsumer consumer = session
          .createDurableSubscriber(destination, "Listener" + i);
      // Setting the listener class whose onMessage method will be called
      // with message as argument
      consumer.setMessageListener(new TopicSubscriber());
    }
  }

  public void onMessage(Message msg) {
    try {

      if (msg instanceof TextMessage) {
        TextMessage text = (TextMessage) msg;
        System.out.println(" - Consuming text msg: " + text.getText());
      } else if (msg instanceof ObjectMessage) {
        ObjectMessage objmsg = (ObjectMessage) msg;
        Object obj = objmsg.getObject();
        System.out.println(" - Consuming object msg: " + obj);
      } else {
        System.out.println(
            " - Unrecognized Message type " + msg.getClass());
      }
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
