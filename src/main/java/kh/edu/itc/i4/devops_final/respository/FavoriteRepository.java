package kh.edu.itc.i4.devops_final.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import kh.edu.itc.i4.devops_final.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {}
