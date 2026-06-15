package kh.edu.itc.i4.devops_final.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long terrainId;
    public Long userId;
    public int rating; // 1 to 5
    @Column(columnDefinition = "TEXT") public String comment;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime updatedAt = LocalDateTime.now();
}
