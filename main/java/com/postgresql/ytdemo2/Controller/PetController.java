package com.postgresql.ytdemo2.Controller;

import com.postgresql.ytdemo2.Service.PetService;
import com.postgresql.ytdemo2.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.postgresql.ytdemo2.repo.PetRepo;

import java.util.List;
import java.util.Optional;
@Controller

public class PetController {


    @Autowired
    PetService petservice;

   @GetMapping("/homePage")
   public String homePage(){
       return "homePage";
   }




    @GetMapping("/addPet")
    public String AddPet(Model model) {
        return petservice.prepareAddPet(model);
    }

    @PostMapping("/addPet")
    public String SavePet(@ModelAttribute("request") Dog dog) {
        return petservice.prepareSavePet(dog);


    }





    //@GetMapping("/success")
    //public String successPage() {
    //    return "index";
    //}


    @GetMapping("/searchPet")
    public String SearchPage(){

        return "dogSearch";
    }



    @GetMapping({"/searchPetViaId"})
    public String IdResults(@RequestParam("id") Long id, Model model) {

        return petservice.prepareIdResults(id,model);



    }




    @GetMapping("/searchPetViaFilter")
    public String filterResults(@RequestParam int minAge,
                                @RequestParam int maxAge,
                                @RequestParam  String breed,
                                @RequestParam  String colour,
                                @RequestParam  String sex,
                                Model model){

        return petservice.prepareFilterResults(minAge,maxAge,breed,colour,sex,model);
        //we could print something to the console here if we want from the details retreived from the database or even create
        //another template and use the details we got back from the database
    }

    @GetMapping("deleteById")
    public String deleteById(){
        return "deleteById";
    }


    @GetMapping("/deletePetUsingId")
    public String deletePet(@RequestParam long id) {
        return petservice.preparedeletePet(id);


    }










}
