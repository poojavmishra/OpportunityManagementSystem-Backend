package org.opportunity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.opportunity.controller.OpportunityController;
import org.opportunity.entity.Opportunity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OpportunityControllerTest {

	
	private Opportunity opportunity = new Opportunity();
	
	@Inject
	OpportunityController opportunityController;
	
//	@BeforeEach
//	void setup() {
//		opportunity = new Opportunity();
//		opportunity.setDescription("Entry Level");
//		opportunity.setId(1);
//		opportunity.setExperience(1);
//		opportunity.setHiringManager("Ruchika");
//		opportunity.setJoiningLocation("Mumbai");
//		opportunity.setRole("Backend Developer");
//		opportunity.setSkills("SpringBoot");
//		
//	}
	
	@Test
    public void Role(){
        opportunity.setRole("Software Engineer");
        String role = opportunity.getRole();
        Assertions.assertEquals("Software Engineer", role);
    }

    @Test
    public void Id(){
        opportunity.setId((long)101);
        Long id = opportunity.getId();
        Assertions.assertEquals(101, id);
    }

    @Test
    public void skills(){
        opportunity.setSkills("Java, Angular");
        String skills = opportunity.getSkills();
        Assertions.assertEquals("Java, Angular", skills);
    }

    @Test
    public void experience(){
        opportunity.setExperience((short)5);
        Integer experience = opportunity.getExperience();
        Assertions.assertEquals(5, experience);
    }

    @Test
    public void publishDate(){
        SimpleDateFormat ft =
                new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        String date_str = ft.format(date).toString();
        opportunity.setPublishDate(date);
        String date_response = ft.format(opportunity.getPublishDate()).toString();
        Assertions.assertEquals(date_str, date_response);
    }

    @Test
    public void hiringManager(){
        opportunity.setHiringManager("Abhijeet Chavan");
        String name = opportunity.getHiringManager();
        Assertions.assertEquals("Abhijeet Chavan", name);
    }

    @Test
    public void description(){
        opportunity.setDescription("Proficient with Java, Angular");
        String skills = opportunity.getDescription();
        Assertions.assertEquals("Proficient with Java, Angular", skills);
    }

    @Test
    public void location(){
        opportunity.setJoiningLocation("Mumbai");
        String location = opportunity.getJoiningLocation();
        Assertions.assertEquals("Mumbai", location);
    }
	
}
