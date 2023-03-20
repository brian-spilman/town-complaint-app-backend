package com.revature.complaintapp.controller;

import com.revature.complaintapp.dto.LoginRequest;
import com.revature.complaintapp.entity.AppUser;
import com.revature.complaintapp.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    Logger logger1 = LoggerFactory.getLogger(AppUserController.class);

    @PostMapping("/appusers")
    public AppUser insert(@RequestBody AppUser appUser) {
        logger1.info("Inserting: " + appUser.toString());
        return appUserService.insert(appUser);
    }

    @RequestMapping(value = "/appusers", method = RequestMethod.GET)
    public List<AppUser> getAll() {
        logger1.info("Getting all app users");
        return appUserService.getAll();
    }

    @GetMapping("/appusers/{userId}")
    public AppUser getById(@PathVariable("userId") Long id) {
        logger1.info("Getting app user of ID: " + id);
        return appUserService.getById(id);
    }

    @PutMapping("/appusers")
    public AppUser update(@RequestBody AppUser appUser) {
        logger1.info("Updating: " + appUser.toString());
        return appUserService.update(appUser);
    }

    @DeleteMapping("/appusers/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting app user of ID: " + id);
        return appUserService.delete(id);
    }

    @PatchMapping("/login")
    public AppUser login(@RequestBody LoginRequest loginRequest) {
        logger1.info("Attempting login of username: " + loginRequest.getUsername());
        List<AppUser> userList = getAll();
        for(AppUser user : userList){
            if(user.getUsername().equals(loginRequest.getUsername()) && user.getPassword().equals(loginRequest.getPassword())) {
                logger1.info("Sign in success");
                return user;
            }
        }
        logger1.info("Sign In Failed");
        return null;
    }

}
