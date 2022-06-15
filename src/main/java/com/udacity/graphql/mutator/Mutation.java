package com.udacity.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private DogRepository dogRepository;

    public Boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for(Dog temp: allDogs) {
            if(temp.getBreed().equals(breed)) {
                dogRepository.delete(temp);
                deleted = true;
            }
        }

        if(!deleted) throw new BreedNotFoundException("Breed not found", breed);
        return deleted;
    }

    public Dog updateDogName(String name, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else throw new DogNotFoundException("Dog not found", id);
    }
}
