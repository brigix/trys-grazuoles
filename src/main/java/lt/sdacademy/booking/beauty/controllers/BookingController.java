package lt.sdacademy.booking.beauty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lt.sdacademy.booking.beauty.models.dto.ServiceDTO;
import lt.sdacademy.booking.beauty.services.BookingService;

@CrossOrigin
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<ServiceDTO> bookingControl(){
        return bookingService.getAll();
    }
}
