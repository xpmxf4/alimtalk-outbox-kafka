package nomucare.alimtalk_outbox_kafka.repository

import nomucare.alimtalk_outbox_kafka.model.OutboxEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OutboxEventRepository : JpaRepository<OutboxEvent, Long> {}