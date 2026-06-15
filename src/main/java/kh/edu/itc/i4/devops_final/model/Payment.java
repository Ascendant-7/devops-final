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
@Table(name = "payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long bookingId;
    public String paymentMethod;
    public BigDecimal amountPaid;
    public LocalDateTime paymentDate = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
    public PaymentStatus status = PaymentStatus.paid;
    public String transactionId;
}
enum PaymentStatus { paid, failed, refunded }
