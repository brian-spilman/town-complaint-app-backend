package com.revature.complaintapp.daotest;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.repository.ComplaintRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class ComplaintDaoTest {

    @Autowired
    ComplaintRepository complaintRepository;

    @Test
    public void testFindByStatus() {
        Complaint complaint1 = new Complaint("Test Description", "UNREVIEWED", -1l);
        Complaint complaint2 = new Complaint("Test Description", "UNREVIEWED", -1l);
        Complaint complaint3 = new Complaint("Test Description", "UNREVIEWED", -1l);
        Complaint complaint4 = new Complaint("Test Description", "IGNORED", -1l);
        complaintRepository.save(complaint1);
        complaintRepository.save(complaint2);
        complaintRepository.save(complaint3);
        complaintRepository.save(complaint4);
        Assertions.assertEquals(3, complaintRepository.findByStatus("UNREVIEWED").size());
    }


}
