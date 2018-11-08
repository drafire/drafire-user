package com.drafire;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");

        //同步调用过程
        DoOrderRequest request1 = new DoOrderRequest();
        request1.setName("drafire");
        IOrderServices services1 = (IOrderServices) context.getBean("orderServices1");
        DoOrderResponse response1 = services1.doOrder(request1);
        System.out.println(response1);

        //异步调用
        IOrderServices services2 = (IOrderServices) context.getBean("orderServices2");
        //立即返回null
        DoOrderResponse response2 = services2.doOrder(request1);
        System.out.println(response2);
        Future<DoOrderResponse> future2 = RpcContext.getContext().getFuture();
        //阻塞直到services2.doOrder(request1) 返回
        response2 = future2.get();
        System.out.println(response2);

        System.out.println("全搞定");
        //Order.doOrder();
        System.in.read();
    }
}
