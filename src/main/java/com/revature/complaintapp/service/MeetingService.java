package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Meeting;
import com.revature.complaintapp.exceptions.IdNotFoundException;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    List<Meeting> getAll();
    Meeting getById(Long id) throws IdNotFoundException;
    Meeting update(Meeting meeting) throws IdNotFoundException;
    boolean delete(Long id) throws IdNotFoundException;
}
