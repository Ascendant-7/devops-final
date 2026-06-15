package kh.edu.itc.i4.devops_final.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "terrains")
public class Terrain {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long ownerId; // references users
    public String title;
    @Column(columnDefinition = "TEXT") public String description;
    public String location;
    public BigDecimal areaSize;
    public BigDecimal pricePerDay;
    public LocalDateTime availableFrom;
    public LocalDateTime availableTo;
    public boolean isAvailable = true;
    public Long mainImageId;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime updatedAt = LocalDateTime.now();
}