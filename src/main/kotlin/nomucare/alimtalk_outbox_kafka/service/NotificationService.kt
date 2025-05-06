package nomucare.alimtalk_outbox_kafka.service

import com.fasterxml.jackson.databind.ObjectMapper
import nomucare.alimtalk_outbox_kafka.model.Reservation
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val objectMapper: ObjectMapper,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["notification-events"], groupId = "notification-service")
    fun consumeNotificationEvent(message: String) {
        log.info("알림 이벤트 수신 : {}", message)

        try {
            // JSON 메세지를 Reservation 객체로 변환
            val reservation = objectMapper.readValue(message, Reservation::class.java)

            // 알림톡 발송 로직 구현
            sendAlimtalk(reservation)
        } catch (e: Exception) {
            log.error("알림 이벤트 처리 중 오류 발생: ${e.message}")
        }
    }

    private fun sendAlimtalk(reservation: Reservation) {
        // 실제로는 알림톡 호출 API 호출 코드가 들어가야 함
        log.info("알림톡 발송: [${reservation.guestName}]님의 예약이 확정되었습니다. " +
                "객실번호: ${reservation.roomNumber}, " +
                "체크인: ${reservation.checkInDate}, " +
                "체크아웃: ${reservation.checkOutDate}")
    }


}