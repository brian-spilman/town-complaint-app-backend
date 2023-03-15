package com.revature.complaintapp.controller;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.entity.Meeting;
import com.revature.complaintapp.service.MeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    Logger logger1 = LoggerFactory.getLogger(MeetingController.class);

    @PostMapping()
    public Meeting insert(@RequestBody Meeting meeting) {
        logger1.info("Inserting: " + meeting.toString());
        return meetingService.insert(meeting);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Meeting> getAll() {
        logger1.info("Getting all meetings");
        return meetingService.getAll();
    }

    @GetMapping("/{meetingId}")
    public Meeting getById(@PathVariable("meetingId") Long id) {
        logger1.info("Getting meeting of ID: " + id);
        return meetingService.getById(id);
    }

    @PutMapping()
    public Meeting update(@RequestBody Meeting meeting) {
        logger1.info("Updating: " + meeting.toString());
        return meetingService.update(meeting);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting meeting of ID: " + id);
        return meetingService.delete(id);
    }

}
