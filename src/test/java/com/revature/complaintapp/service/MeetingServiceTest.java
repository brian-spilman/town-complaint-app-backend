package com.revature.complaintapp.service;

import com.revature.complaintapp.entity.Complaint;
import com.revature.complaintapp.entity.Meeting;
import com.revature.complaintapp.repository.ComplaintRepository;
import com.revature.complaintapp.repository.MeetingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MeetingServiceTest {

    @MockBean(MeetingRepository.class)
    private MeetingRepository meetingRepository;

    @Autowired
    MeetingService meetingService;

    @Test
    public void testInsert() {
        Meeting meeting = new Meeting("TEST MEETING ADDRESS", 0l, "TEST MEETING");
        Meeting insertedMeeting = new Meeting(1l, "TEST MEETING ADDRESS", 0l, "TEST MEETING");

        Mockito.when(meetingRepository.save(meeting)).thenReturn(insertedMeeting);
        Assertions.assertEquals(insertedMeeting, meetingService.insert(meeting));
    }

    @Test
    public void testGetById() {

        Long meeting_id = 1l;
        Meeting expectedMeeting = new Meeting(1l, "TEST MEETING ADDRESS", 0l, "TEST MEETING");

        Mockito.when(meetingRepository.findById(meeting_id)).thenReturn(Optional.of(expectedMeeting));

        Assertions.assertEquals(expectedMeeting, meetingService.getById(meeting_id));

    }

    @Test
    public void testGetAll() {

        Meeting meeting = new Meeting(1l, "TEST MEETING ADDRESS", 0l, "TEST MEETING");
        List<Meeting> meetingList = new ArrayList<>();
        meetingList.add(meeting);

        Mockito.when(meetingRepository.findAll()).thenReturn(meetingList);

        Assertions.assertEquals(meetingList, meetingService.getAll());

    }

    @Test
    public void testUpdate() {

        Meeting meeting = new Meeting(1l, "TEST MEETING ADDRESS", 0l, "TEST MEETING");
        Meeting updatedMeeting = new Meeting(1l, "TEST MEETING ADDRESS", 0l, "TEST MEETING");

        Mockito.when(meetingRepository.save(meeting)).thenReturn(updatedMeeting);
        Assertions.assertEquals(updatedMeeting, meetingService.update(meeting));

    }

    @Test
    public void testDelete() {

        Long meeting_id = 1l;

        Mockito.when(meetingRepository.existsById(meeting_id)).thenReturn(true);

        Assertions.assertEquals(true, meetingService.delete(meeting_id));

    }

}
