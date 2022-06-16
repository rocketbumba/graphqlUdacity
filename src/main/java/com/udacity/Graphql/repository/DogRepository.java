package com.udacity.Graphql.repository;

import com.udacity.Graphql.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    @Query(value = "select d.id, d.name from Dog d", nativeQuery = true)
    List<String> findAllName();

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);
}
