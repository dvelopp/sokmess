package hello;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage1(String message) {
        if(canProcess){
            System.out.println("Received 1 <" + message + ">");
        }
    }

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage2(String message) {
        if(canProcess){
            System.out.println("Received 2 <" + message + ">");
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
