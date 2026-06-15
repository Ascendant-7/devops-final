package kh.edu.itc.i4.devops_final.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long terrainId;
    public Long renterId;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public BigDecimal totalPrice;
    
    @Enumerated(EnumType.STRING)
    public BookingStatus status = BookingStatus.pending;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime updatedAt = LocalDateTime.now();
}
enum BookingStatus { pending, approved, rejected, cancelled, completed }
