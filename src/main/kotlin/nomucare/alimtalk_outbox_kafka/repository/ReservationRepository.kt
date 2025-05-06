package nomucare.alimtalk_outbox_kafka.repository

import nomucare.alimtalk_outbox_kafka.model.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Long>