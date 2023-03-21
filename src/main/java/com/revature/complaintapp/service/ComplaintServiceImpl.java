package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.exceptions.IdNotFoundException;
import com.revature.complaintapp.repository.ComplaintRepository;
import com.revature.complaintapp.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public Complaint insert(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getById(Long complaint_id) throws IdNotFoundException {
        if(!complaintRepository.existsById(complaint_id)) throw new IdNotFoundException();
        return complaintRepository.findById(complaint_id).get();
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint update(Complaint complaint) throws IdNotFoundException {
        if(!complaintRepository.existsById(complaint.getComplaint_id())) throw new IdNotFoundException();
        return complaintRepository.save(complaint);
    }

    @Override
    public boolean delete(Long complaint_id) {
        boolean found = complaintRepository.existsById(complaint_id);
        if(found) {
            complaintRepository.deleteById(complaint_id);
        }
        return found;
    }

    @Override
    public List<Complaint> getByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }
}
