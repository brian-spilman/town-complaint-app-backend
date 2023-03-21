package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.exceptions.IdNotFoundException;

import java.util.List;

public interface ComplaintService {
    Complaint insert(Complaint complaint);
    Complaint getById(Long complaint_id) throws IdNotFoundException;
    List<Complaint> getAll();
    Complaint update(Complaint complaint) throws IdNotFoundException;
    boolean delete(Long complaint_id);
    List<Complaint> getByStatus(String status);
}
