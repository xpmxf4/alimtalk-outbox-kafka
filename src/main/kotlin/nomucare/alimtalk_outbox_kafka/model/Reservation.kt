package nomucare.alimtalk_outbox_kafka.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "outbox_events")
data class Reservation (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val aggregateType: String,
    val aggregateId: String,
    val eventType: String,
    @Column(columnDefinition = "TEXT")
    val payload: String,
    val createdAt: Instant = Instant.now(),
    var processed: Boolean = false,
)