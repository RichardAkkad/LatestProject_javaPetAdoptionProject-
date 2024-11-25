package com.postgresql.ytdemo2.Service;

import com.postgresql.ytdemo2.model.Dog;
import com.postgresql.ytdemo2.repo.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepo repo;

    public String prepareAddPet(Model model) {
        model.addAttribute("request", new Dog());

        return "saveDog";
    }


    public String prepareSavePet(Dog dog) {

        repo.save(dog);
        return "index";

    }


    public String prepareIdResults(Long id, Model model) {
        Optional<Dog> dog = repo.findById(id);
        System.out.println(id);

        if (dog.isPresent()) {
            model.addAttribute("dog", dog.get());//"dog.get()" just returns a object which is stored in the Optional container, and then we are reassigning this object to another variable called "dog" again
            return "dogIdResults"; // This page will display the dog's details
        }
        else {
            return "incorrectId"; // Redirect back to search page with error message
        }

    }
        public String prepareFilterResults(int minAge, int maxAge, String breed, String colour, String sex, Model model) {
            List<Dog> dogs = repo.filterResults(minAge, maxAge, breed, colour, sex);
            System.out.println(dogs.size() + "-----------");
            model.addAttribute("dogs", dogs);
            return "dogFilterResults";
        }


        public String preparedeletePet( long id){
            List<Dog> dogs = repo.findAll();
            for (Dog dog : dogs) {
                if (dog.getId() == id) {
                    repo.deleteById(id);
                    return "deleteSuccess";
                }
            }
            return "deleteFailed";


        }










    }






















