package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser insert(AppUser appUser);
    AppUser getById(Long userId);
    List<AppUser> getAll();
    AppUser update(AppUser appUser);
    boolean delete(Long userId);
}
