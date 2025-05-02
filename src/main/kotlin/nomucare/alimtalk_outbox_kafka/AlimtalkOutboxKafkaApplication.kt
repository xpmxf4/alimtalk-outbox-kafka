package nomucare.alimtalk_outbox_kafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AlimtalkOutboxKafkaApplication

fun main(args: Array<String>) {
	runApplication<AlimtalkOutboxKafkaApplication>(*args)
}
