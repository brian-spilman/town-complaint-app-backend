package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Meeting;
import com.revature.complaintapp.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public Meeting insert(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getById(Long id) {
        return meetingRepository.findById(id).get();
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = meetingRepository.existsById(id);
        if(found) { meetingRepository.deleteById(id); }
        return found;
    }
}
