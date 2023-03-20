package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.AppUser;
import com.revature.complaintapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser insert(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getById(Long userId) {
        return appUserRepository.findById(userId).get();
    }

    @Override
    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public boolean delete(Long userId) {
        boolean found = appUserRepository.existsById(userId);
        if(found) {
            appUserRepository.deleteById(userId);
        }
        return found;
    }
}
