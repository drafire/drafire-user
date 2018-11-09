package com.drafire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集群负载均衡测试测试
 * dubbo本身已经集成了负载均衡的功能，只需要把代码部署到不同的服务器，这个时候，端口号可以一样。
 * 如果是本地的两个进程，则需要修改端口号，要不会引起端口号冲突
 * 而对于客户端来说，是不关心端口号的，客户端关心的只是服务名字而已
 */
public class SubscribeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");

        for (int i=0;i<10;i++){
            //同步调用过程
            DoOrderRequest request1 = new DoOrderRequest();
            request1.setName("drafire");
            IOrderServices services1 = (IOrderServices) context.getBean("orderServices1");
            DoOrderResponse response1 = services1.doOrder(request1);
            System.out.println(response1);
        }

    }
}
