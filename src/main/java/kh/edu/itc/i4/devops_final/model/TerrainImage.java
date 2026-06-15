package kh.edu.itc.i4.devops_final.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "terrain_images")
public class TerrainImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long terrainId;
    public String imagePath;
    public LocalDateTime uploadedAt = LocalDateTime.now();
}
