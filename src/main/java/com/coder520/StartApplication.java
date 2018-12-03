package com.coder520;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liugang
 * @create 2018/11/28 14:10
 **/
public class StartApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-activemq.xml");
        MessageService messageService = (MessageService) ctx.getBean("messageService");

        messageService.sendQueueMessage("我的测试消息1");
        messageService.sendTopicMessage("我的测试消息2");
        messageService.sendTopicMessage("我的测试消息3");

    }
}
