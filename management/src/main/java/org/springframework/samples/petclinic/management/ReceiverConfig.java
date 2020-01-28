package org.springframework.samples.petclinic.management;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.JMSException;

@Configuration
@EnableJms
public class ReceiverConfig {

    //  @Value("${activemq.broker-url}")
    private String brokerUrl = "tcp://localhost:61616";

//  @Value("${destination.status1}")
//  private String status1Destination;

//  @Value("${destination.status2}")
//  private String status2Destination;

    @Bean
    public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        return activeMQConnectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory orderDefaultJmsListenerContainerFactory() throws JMSException {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());
        factory.setConcurrency("3-10");
        return factory;
    }

    @Bean
    public SimpleJmsListenerContainerFactory orderSimpleJmsListenerContainerFactory() throws JMSException {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());
        return factory;
    }

//    @Bean
//    public DefaultMessageListenerContainer orderMessageListenerContainer() throws JMSException {
//        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
//        endpoint.setMessageListener(new StatusMessageListener("DMLC"));
//        endpoint.setDestination(status1Destination);
//
//        return orderDefaultJmsListenerContainerFactory().createListenerContainer(endpoint);
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer statusMessageListenerContainer() throws JMSException {
//        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
//        endpoint.setMessageListener(new StatusMessageListener("SMLC"));
//        endpoint.setDestination(status2Destination);
//        return orderSimpleJmsListenerContainerFactory().createListenerContainer(endpoint);
//    }
}