package zipkin4.producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import zipkin4.message.DemoMessage;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Component
public class DemoProducer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        // 创建 DemoMessage 消息
        DemoMessage message = new DemoMessage();
        message.setId(id);
        // 同步发送消息
        return kafkaTemplate.send(DemoMessage.TOPIC, message).get();
    }
}