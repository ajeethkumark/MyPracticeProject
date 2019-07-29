package jms;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.TransportListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

public class MessageReceiver implements MessageListener,TransportListener {
//,BeanPostProcessor {
/*	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private  Topic topic; */
	
	private boolean connected = false;
    private Connection connection = null;
    private MessageConsumer consumer = null;
    private Session session = null;
    private int RETRY_DELAY = 2000;
	public static Boolean TRANSACTIONAL = false;
	public static String TOPIC_NAME = "firstTopic";
	public boolean threadFlag=true;
	ActiveMQConnectionFactory factory;

	 public MessageReceiver(){
		 System.out.println("MessageReceiver");
	 }
	 
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
            TextMessage text = (TextMessage) message;
            try {
				System.out.println(text.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
        }
		else{
			System.out.println("It not a text Object");
		}
	}

//	@Override
//	public Object postProcessAfterInitialization(Object arg0, String arg1)  {
//		System.out.println("MessageReceiver postProcessAfterInitialization called");
//		//initConnection();
//		return null;
//	}
	
	
	@PostConstruct
	public void Test() throws JMSException
	{
		System.out.println("Post Method Test");
		Thread t = new Thread() 
        { 
            public void run() 
            { 
                System.out.println("Child Thread"); 
                try {
					initConnection();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
        }; 
        t.start();
       // initConnection();
	}
	@PreDestroy
	   public void destroy() {
		
	     
	      System.out.println("Inside destroy method - ");
	      threadFlag=false;
	     
	      try
	      {
	      if( connection != null )
	        {
	            connection.close();
	        }
	        if( consumer != null )
	        {
	            consumer.close();
	        }
	        if( session != null )
	        {
	            session.close();
	        }
	      //  factory.getTransportListener().
	      }
	      catch(JMSException e)
	      {
	    	  System.out.println("JMSException:"+e.getMessage());
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("Exception:"+e.getMessage());
	      }
	   }

	private void initConnection() throws JMSException {
		// TODO Auto-generated method stub
		try
		{ 
		 String host="192.168.1.70";
		    String port="61616";
		    System.out.println("InitConnectionMedoth called...");
		    // Creating Factory for connection
		/*    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
		        "tcp://" + host + ":" + port); */
		    
    factory=new ActiveMQConnectionFactory("failover:(tcp://192.168.1.70:61616)?timeout=5000");
	factory.setTransportListener(this);
		     connection = factory.createConnection();
		    // Setting unique client id for durable subscriber
		    connection.setClientID("Performance_Data");
		    
		    while(session==null)
		    {
		    	try
		    	{
		    		session = connection.createSession( TRANSACTIONAL, Session.AUTO_ACKNOWLEDGE );
		    	}
		    	catch(Exception e)
		    	{
		    		 e.printStackTrace();
		    	}
		    	if(session==null)
		    		System.out.println( "Unable to create ActiveMQ Session" );
                Thread.sleep( RETRY_DELAY );
		    }
		    
		    
		    connection.start();
		    // Create 3 new consumers for the topic
		    for (int i = 1; i <= 3; i++) {
		    	
		    	
		  /*    Session session = connection.createSession(TRANSACTIONAL,
		          Session.AUTO_ACKNOWLEDGE); */
		    	
		    	
		      Topic destination = session.createTopic(TOPIC_NAME);
		      consumer = session
		          .createDurableSubscriber(destination, "Listener" + i);
		      // Setting the listener class whose onMessage method will be called
		      // with message as argument
		      consumer.setMessageListener(new MessageReceiver());
		      
		      
		    } 
		    while( threadFlag )
	        {
	            if( !connected )
	            {
	                System.out.println( "Transport Interrupted or IOException" );
	            }
	            Thread.sleep( RETRY_DELAY );
	        }
		}
		catch(Exception e)
		{
			System.out.println("Exception while connecting to activemq and subcribing....."+e.getMessage());
			
		}
		
	}

	@Override
	public void onCommand(Object command) {
		// TODO Auto-generated method stub
	//	System.out.println( "Command - " + command );
		
	}

	@Override
	public void onException(IOException arg0) {
		// TODO Auto-generated method stub
		connected = false;
		
	}

	@Override
	public void transportInterupted() {
		// TODO Auto-generated method stub
		connected = false;
		
	}

	@Override
	public void transportResumed() {
		// TODO Auto-generated method stub
		connected = true;
		
	}

//	@Override
//	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
//		// TODO Auto-generated method stub
//		return null;
//	}
/*	public void test()
	{
		 ActiveMQConnectionFactory factory=(ActiveMQConnectionFactory) jmsTemplate.getConnectionFactory();
		 Connection connection=factory.
	}*/

}
