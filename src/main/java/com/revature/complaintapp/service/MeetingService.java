package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    List<Meeting> getAll();
    Meeting getById(Long id);
    Meeting update(Meeting meeting);
    boolean delete(Long id);
}
