package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private DogRepository dogRepository;

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Optional<Dog> findDogById(Long id) {
        return dogRepository.findById(id);
    }

}
