import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class BasicProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);
        EventObject event = new EventObject(1, "Hello from i2i Academy!");

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(event);
            byte[] data = bos.toByteArray();
            producer.send(new ProducerRecord<>("i2i-topic", "key1", data));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}