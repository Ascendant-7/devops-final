package kh.edu.itc.i4.devops_final;

import org.springframework.web.bind.annotation.*;

import kh.edu.itc.i4.devops_final.model.*;
import kh.edu.itc.i4.devops_final.respository.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final TerrainRepository terrainRepo;
    private final TerrainImageRepository imageRepo;
    private final BookingRepository bookingRepo;
    private final PaymentRepository paymentRepo;
    private final ReviewRepository reviewRepo;
    private final FavoriteRepository favoriteRepo;

    // Constructor injection replaces all field-level @Autowired annotations
    public ApiController(
        TerrainRepository terrainRepo,
        TerrainImageRepository imageRepo,
        BookingRepository bookingRepo,
        PaymentRepository paymentRepo,
        ReviewRepository reviewRepo,
        FavoriteRepository favoriteRepo
    ) {
        this.terrainRepo = terrainRepo;
        this.imageRepo = imageRepo;
        this.bookingRepo = bookingRepo;
        this.paymentRepo = paymentRepo;
        this.reviewRepo = reviewRepo;
        this.favoriteRepo = favoriteRepo;
    }

    @GetMapping("/terrains") public List<Terrain> getTerrains() { return terrainRepo.findAll(); }
    @GetMapping("/images") public List<TerrainImage> getImages() { return imageRepo.findAll(); }
    @GetMapping("/bookings") public List<Booking> getBookings() { return bookingRepo.findAll(); }
    @GetMapping("/payments") public List<Payment> getPayments() { return paymentRepo.findAll(); }
    @GetMapping("/reviews") public List<Review> getReviews() { return reviewRepo.findAll(); }
    @GetMapping("/favorites") public List<Favorite> getFavorites() { return favoriteRepo.findAll(); }
}