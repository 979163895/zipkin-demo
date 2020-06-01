package zipkin4;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zipkin4.producer.DemoProducer;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("zipkin")
public class Zipkinkafka4Controller {
    public static final String url = "http://localhost:8085/zipkin/service5";

    @Autowired
    OkHttpClient client;

    @GetMapping("/service4")
    public String service() throws Exception {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return "con4 + "+ response.body().string();
    }

    /* kafka */

    @Autowired
    private DemoProducer producer;

    @GetMapping("/kafka")
    public String echo() throws ExecutionException, InterruptedException {
        this.sendMessage(1);
        return "kafka";
    }

    public void sendMessage(Integer id) throws ExecutionException, InterruptedException {
        producer.syncSend(id);
    }
}