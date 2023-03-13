package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint insert(Complaint complaint);
    Complaint getById(Long complaint_id);
    List<Complaint> getAll();
    Complaint update(Complaint complaint);
    boolean delete(Long complaint_id);
}
