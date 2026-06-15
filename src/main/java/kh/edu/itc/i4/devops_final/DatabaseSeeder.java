package kh.edu.itc.i4.devops_final;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kh.edu.itc.i4.devops_final.model.*;
import kh.edu.itc.i4.devops_final.respository.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    // 1. Declare fields as private final
    private final TerrainRepository terrainRepo;
    private final TerrainImageRepository imageRepo;
    private final BookingRepository bookingRepo;
    private final PaymentRepository paymentRepo;
    private final ReviewRepository reviewRepo;
    private final FavoriteRepository favoriteRepo;

    // 2. Inject via single constructor (No @Autowired required if it's the only constructor)
    public DatabaseSeeder(
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

    @Override
    public void run(String... args) throws Exception {
        if (terrainRepo.count() == 0) {
            // --- 1. Seed Terrain Image ---
            TerrainImage img = new TerrainImage();
            img.terrainId = 1L;
            img.imagePath = "/images/field1.jpg";
            imageRepo.save(img);

            // --- 2. Seed Terrain ---
            Terrain terrain = new Terrain();
            terrain.title = "Phnom Penh Turf";
            terrain.location = "Phnom Penh";
            terrain.areaSize = new BigDecimal("1200.00");
            terrain.pricePerDay = new BigDecimal("100.00");
            terrain.mainImageId = 1L;
            terrainRepo.save(terrain);

            // --- 3. Seed Booking ---
            Booking booking = new Booking();
            booking.terrainId = 1L;
            booking.renterId = 99L;
            booking.startDate = LocalDateTime.now();
            booking.endDate = LocalDateTime.now().plusHours(2);
            booking.totalPrice = new BigDecimal("20.00");
            bookingRepo.save(booking);

            // --- 4. Seed Payment ---
            Payment payment = new Payment();
            payment.bookingId = 1L;
            payment.paymentMethod = "ABA Pay";
            payment.amountPaid = new BigDecimal("20.00");
            paymentRepo.save(payment);

            // --- 5. Seed Review ---
            Review review = new Review();
            review.terrainId = 1L;
            review.userId = 99L;
            review.rating = 5;
            review.comment = "Great pitch!";
            reviewRepo.save(review);

            // --- 6. Seed Favorite ---
            Favorite fav = new Favorite();
            fav.userId = 99L;
            fav.terrainId = 1L;
            favoriteRepo.save(fav);

            System.out.println(">>> All 6 Modules Seeded Successfully via Constructor Injection!");
        }
    }
}