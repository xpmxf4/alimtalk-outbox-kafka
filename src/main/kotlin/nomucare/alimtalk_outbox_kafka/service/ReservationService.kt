package nomucare.alimtalk_outbox_kafka.service

import com.fasterxml.jackson.databind.ObjectMapper
import nomucare.alimtalk_outbox_kafka.model.OutboxEvent
import nomucare.alimtalk_outbox_kafka.model.Reservation
import nomucare.alimtalk_outbox_kafka.repository.OutboxEventRepository
import nomucare.alimtalk_outbox_kafka.repository.ReservationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository,
    private val outboxEventRepository: OutboxEventRepository,
    private val objectMapper: ObjectMapper,
) {
    @Transactional
    fun createReservation(reservation: Reservation): Reservation {

        // 1. 예약 정보를 저장합니다.
        val savedReservation = reservationRepository.save(reservation)

        // 2. 아웃박스 이벤트를 생성합니다.
        val eventPayload = objectMapper.writeValueAsString(savedReservation)
        val outboxEvent = OutboxEvent(
            aggregateType = "Reservation",
            aggregateId = savedReservation.id.toString(),
            eventType = "reservation_created",
            payload = eventPayload
        )

        // 3. 같은 트랜잭션에서 아웃박스 이벤트를 저장합니다.
        outboxEventRepository.save(outboxEvent)

        return savedReservation
    }

    fun getReservationById(id: Long): Reservation? {
        return reservationRepository.findById(id).orElse(null)
    }

    fun getAllReservations(): List<Reservation> {
        return reservationRepository.findAll()
    }
}