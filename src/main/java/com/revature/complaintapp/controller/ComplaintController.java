package com.revature.complaintapp.controller;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.exceptions.IdNotFoundException;
import com.revature.complaintapp.service.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);

    @PostMapping()
    public ResponseEntity<Complaint> insert(@RequestBody Complaint complaint) {
        logger1.info("Inserting: " + complaint.toString());
        return new ResponseEntity<Complaint>(complaintService.insert(complaint), HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll() {
        logger1.info("Getting all complaints");
        return complaintService.getAll();
    }

    @GetMapping("/{complaintId}")
    public Complaint getById(@PathVariable("complaintId") Long id) throws IdNotFoundException {
        logger1.info("Getting complaint of ID: " + id);
        return complaintService.getById(id);
    }

    @PutMapping()
    public Complaint update(@RequestBody Complaint complaint) throws IdNotFoundException {
        logger1.info("Updating: " + complaint.toString());
        return complaintService.update(complaint);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        logger1.info("Deleting complaint of ID: " + id);
        return complaintService.delete(id);
    }

    @GetMapping("/status/{status}")
    public List<Complaint> getByStatus(@PathVariable("status") String status) {
        logger1.info("Searching complaints with status: " + status);
        return complaintService.getByStatus(status);
    }

}
