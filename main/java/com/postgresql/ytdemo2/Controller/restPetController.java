package com.postgresql.ytdemo2.Controller;

import com.postgresql.ytdemo2.model.Dog;
import com.postgresql.ytdemo2.repo.PetRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class restPetController {
    @Autowired
    PetRepo repo;

    @PostMapping("/insertPet")
//whether we click on this endpoint(from the home page or manually type it in this method needs to happen
    public void addPet(@RequestBody Dog dog) {

        repo.save(dog);
        //Dog myDog=repo.save(dog);
        //return myDog;

    }

    @GetMapping("/getPetById")
    public Dog GetPetId(@RequestParam long id) {

        return repo.findById(id);// looks like "Dog findById(long id);" in PetRepo interface allows this method to return a object and not a optional
        // while in the controller example we return a optional using "Optional<Dog>" for the "IdResults" method as the type and "Dog findById(long id);"
    }       // in the PetRepo interface doesnt overide this


    @GetMapping("/getAll")
    public List<Dog> getAll() {

        return repo.findAll();

    }


    @GetMapping("/getSpecific")
    public List<Dog> filter() {

        return repo.filterPostman(0, 5, "terrier", "grey", "male");//manual input of values because not inputting the values into the form

    }


    @GetMapping("/deletePetById")
    public String deletePet(@RequestParam long id) {
        List<Dog> dogs = repo.findAll();
        for (Dog dog : dogs) {
            if (dog.getId() == id) {
                repo.deleteById(id);
                return "deleteSuccess";
            }
        }

        return "deleteFailed";

    }


    //if (repo.existsById(id)) {
    //    repo.deleteById(id);
    //    return "deleteSuccess";
    //}

    //return "deleteFailed";

    //}



    //COME BACK TO APPARENTLY,HAVE CREATED ANOTHER REPOSITORY BUT STILL NOT WORKING
    //@PostMapping("/CreateUser")
    //public String addUser(@RequestBody User user) {

    //    repo.save(user);
    //    return "saved User";

    //}




}
