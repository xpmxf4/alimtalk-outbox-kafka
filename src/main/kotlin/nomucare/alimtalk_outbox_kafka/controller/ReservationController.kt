package nomucare.alimtalk_outbox_kafka.controller

import nomucare.alimtalk_outbox_kafka.model.OutboxEvent
import nomucare.alimtalk_outbox_kafka.model.Reservation
import nomucare.alimtalk_outbox_kafka.service.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/reservations")
class ReservationController (
    private val reservationService: ReservationService
){
    @PostMapping
    fun createReservation(@RequestBody reservation: Reservation): ResponseEntity<Reservation> {
        val createdReservation = reservationService.createReservation(reservation)
        return ResponseEntity.ok(createdReservation)
    }

    @GetMapping("/{id}")
    fun getReservationById(@PathVariable("id") id: Long): ResponseEntity<Reservation> {
        val reservation = reservationService.getReservationById(id)
        return if (reservation != null) {
            ResponseEntity.ok(reservation)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllReservations(): ResponseEntity<List<Reservation>> {
        val reservations = reservationService.getAllReservations()
        return ResponseEntity.ok(reservations)
    }
}