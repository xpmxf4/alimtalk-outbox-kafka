package nomucare.alimtalk_outbox_kafka.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class OutboxEvent(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val guestName: String,
    val roomNumber: String,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate,
    @Enumerated(EnumType.STRING) val status: ReservationStatus = ReservationStatus.CONFIRMED
)

enum class ReservationStatus {
    CONFIRMED, CANCELLED, CHECKED_IN, CHECKED_OUT,
}