package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.repository.ComplaintRepository;
import com.revature.complaintapp.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Complaint getById(Long complaint_id) {
        return complaintRepository.findById(complaint_id).get();
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint update(Complaint complaint) {
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
}
