package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.repository.ComplaintRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//
@SpringBootTest
public class ComplaintServiceTest {

    @MockBean(ComplaintRepository.class)
    private ComplaintRepository complaintRepository;

    @Autowired
    ComplaintService complaintService;

    @Test
    public void testInsert() {

        // initialize a complaint to insert:
        Complaint complaint = new Complaint("This is a test", "UNREVIEWED", -1l);
        // creating the expected complaint object once it is inserted and an id is generated:
        Complaint insertedComplaint = new Complaint(2l, "This is a test", "UNREVIEWED", -1l);

        // mock the save method of the repository, so the repository doesn't actually access the database
        // whenever the .save method is called, it will return the complaint object that we created in this test case
        Mockito.when(complaintRepository.save(complaint)).thenReturn(insertedComplaint);

        // ensure that the service returns the inserted complaint
        Assertions.assertEquals(insertedComplaint, complaintService.insert(complaint));

    }

    @Test
    public void testGetById() {

        // Complaint complaint = new Complaint("This is a test", "UNREVIEWED", -1l);
        Long complaint_id = 1l;
        Complaint expectedComplaint = new Complaint(1l, "This is a test", "UNREVIEWED", -1l);

        // Optional<Complaint> = Optional.of(expectedComplaint);
        Mockito.when(complaintRepository.findById(complaint_id)).thenReturn(Optional.of(expectedComplaint));

        Assertions.assertEquals(expectedComplaint, complaintService.getById(complaint_id));

    }

    @Test
    public void testGetAll() {

        Complaint complaint = new Complaint(1l, "This is a test", "UNREVIEWED", -1l);
        List<Complaint> complaintList = new ArrayList<>();
        complaintList.add(complaint);

        Mockito.when(complaintRepository.findAll()).thenReturn(complaintList);

        Assertions.assertEquals(complaintList, complaintService.getAll());

    }

    @Test
    public void testUpdate() {

        // initialize a complaint to insert:
        Complaint complaint = new Complaint(1l, "This is a test", "UNREVIEWED", -1l);
        // creating the expected complaint object once it is inserted and an id is generated:
        Complaint updatedComplaint = new Complaint(1l, "This is a test", "UNREVIEWED", -1l);

        // mock the save method of the repository, so the repository doesn't actually access the database
        // whenever the .save method is called, it will return the complaint object that we created in this test case
        Mockito.when(complaintRepository.save(complaint)).thenReturn(updatedComplaint);

        // ensure that the service returns the inserted complaint
        Assertions.assertEquals(updatedComplaint, complaintService.update(complaint));

    }

    @Test
    public void testDelete() {

        Long complaint_id = 1l;

        Mockito.when(complaintRepository.existsById(complaint_id)).thenReturn(true);

        Assertions.assertEquals(true, complaintService.delete(complaint_id));

    }

}
