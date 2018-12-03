package com.coder520;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author liugang
 * @create 2018/11/28 14:04
 **/
public class QueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try{
                TextMessage textMessage = (TextMessage)message;
                String messageStr = textMessage.getText();
                System.out.println("队列监听器接受到文本消息："+messageStr);
            }catch (JMSException e){
                e.printStackTrace();
            }
        }else{
            throw new IllegalArgumentException("只支持 TextMessage 类型消息！");
        }
    }
}
