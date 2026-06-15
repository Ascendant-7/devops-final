package kh.edu.itc.i4.devops_final.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long userId;
    public Long terrainId;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime updatedAt = LocalDateTime.now();
}