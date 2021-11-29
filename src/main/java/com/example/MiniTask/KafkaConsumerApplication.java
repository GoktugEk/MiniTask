package com.example.MiniTask;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.internals.ConsumerMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.EnableKafka;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

@EnableKafka


public class KafkaConsumerApplication {
    private static Consumer<String, String> consumer;
    private static boolean KeepConsuming = true;
    private static Properties loadProperties;

    public KafkaConsumerApplication(Consumer<String, String> consumer, ConsumerRecordsHandler<String, String> recordsHandler) {
        this.consumer = consumer;
    }

    public static void runConsume(final Properties consumerProps){
        try {
            consumer.subscribe(Collections.singleton("test_db_kangaroo"));
            while (KeepConsuming){
                final ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
                consumerRecords.notify();
            }
        } finally {
            consumer.close();
        }
    }

    public static Properties loadProperties(String fileName) throws IOException {
        final Properties props = new Properties();
        final FileInputStream input = new FileInputStream(fileName);
        props.load(input);
        input.close();
        return props;
    }

    public static void main(String[] args) throws IOException {


        final Properties consumerAppProps = KafkaConsumerApplication.loadProperties(System.getProperty("user.dir")+"/src/main/java/com/example/MiniTask/dev.properties");
        final String filePath = consumerAppProps.getProperty("file.path");
        final Consumer<String, String> consumer = new KafkaConsumer<>(consumerAppProps);
        final ConsumerRecordsHandler<String, String> recordsHandler = new FileWritingRecordsHandler(Paths.get(filePath));
        KafkaConsumerApplication consumerApplication = new KafkaConsumerApplication(consumer, recordsHandler);

        Runtime.getRuntime().addShutdownHook(new Thread(consumerApplication::shutdown));
        runConsume(consumerAppProps);
    }

    private void shutdown() {
        KeepConsuming = false;
    }
}
