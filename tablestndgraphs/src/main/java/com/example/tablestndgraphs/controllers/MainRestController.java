package com.example.tablestndgraphs.controllers;

import com.example.tablestndgraphs.dao.StaticUserServiceDB;
import com.example.tablestndgraphs.models.RateToHryvnia;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping(value = "/api")
public class MainRestController {

    private static final Logger log = LogManager.getLogger(MainRestController.class);

   @Autowired
    StaticUserServiceDB staticUserServiceDB;

   @GetMapping(value = "/getUser/{login}")
    public String getUserByLogin(@PathVariable String login){
       log.info("getUserByLogin"+login);
       try{
           return new Gson().toJson(staticUserServiceDB.findByLoginn(login));
       }catch(NullPointerException e){
            log.error("null");
       }
       return "";
   }

    @GetMapping(value = "/getUsersinformation")
    public String getUsersInformation(){
        log.info("getUsersInformation");
        return new Gson().toJson(staticUserServiceDB.getUsersInformationsList());
    }

    @GetMapping(value = "/getRateToHryvnia")
    public String getRateToHryvnia(){
        log.info("getRateToHryvnia");
        RateToHryvnia rateToHryvnia1=new RateToHryvnia("USD",
            Double.toString(23+Math.random()*7), Double.toString(23+Math.random()*7), Double.toString(23+Math.random()*7),
                Double.toString(23+Math.random()*7));
        RateToHryvnia rateToHryvnia2=new RateToHryvnia("EUR",
                Double.toString(28+Math.random()*10), Double.toString(28+Math.random()*10), Double.toString(28+Math.random()*10),
                Double.toString(28+Math.random()*10));
        List<RateToHryvnia> listtmp = new ArrayList<>();
        listtmp.add(rateToHryvnia1);
        listtmp.add(rateToHryvnia2);
        return new Gson().toJson(listtmp);
    }




}
