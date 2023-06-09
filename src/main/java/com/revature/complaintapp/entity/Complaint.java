package com.revature.complaintapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaint_id;
    private String description;
    private String status;
    private Long meeting_id;

    public Complaint(String description, String status, Long meeting_id) {
        this.description = description;
        this.status = status;
        this.meeting_id = meeting_id;
    }

}
