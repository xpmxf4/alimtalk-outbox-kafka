package nomucare.alimtalk_outbox_kafka.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    fun sendNotificationEvent(key: String, event: String) {
        kafkaTemplate.send("notification-events", key, event)
            .whenComplete { result, ex ->
            if (ex == null) {
                println("메세지 전송 성공: $key")
            } else {
                println("메세지 전송 실패: $key, 에러: ${ex.message}")
            }
        }
    }
}