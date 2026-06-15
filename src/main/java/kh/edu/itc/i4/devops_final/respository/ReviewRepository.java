package kh.edu.itc.i4.devops_final.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import kh.edu.itc.i4.devops_final.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {}
