package com.coder520;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author liugang
 * @create 2018/11/28 13:34
 **/
@Service("messageService")
public class MessageService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "testQueue")
    private Destination testQueue;

    @Resource(name = "testTopic")
    private Destination testTopic;

    public void sendQueueMessage(final String messageContent){
        jmsTemplate.send(testQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage();
                //set message content
                msg.setText(messageContent);
                return msg;
            }
        });
    }

    //向主题发送消息
    public void sendTopicMessage(final String messageContent) {
        jmsTemplate.send(testTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage();
                // 设置消息内容
                msg.setText(messageContent);
                return msg;
            }
        });

    }

}
