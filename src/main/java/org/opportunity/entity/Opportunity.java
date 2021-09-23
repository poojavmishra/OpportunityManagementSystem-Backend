package org.opportunity.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "Opportunity")
public class Opportunity extends PanacheMongoEntityBase{

	@BsonId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@BsonProperty("opportunity_id")
	public long opportunityId;
	
	@BsonProperty("role")
	public String role;

	@BsonProperty("skills")
	public String skills;
	
	@BsonProperty("publish_date")
	public Date publishDate;
	
	@BsonProperty("joining_location")
	public String JoiningLocation;
	
	@BsonProperty("hiring_manager")
	public String HiringManager;
	
	@BsonProperty("description")
	public String Description;
	
	@BsonProperty("experience")
	public Integer Experience;
	
	public Opportunity() {
		
	}

	public Opportunity(long id, String role, String skills, Date publishDate, String joiningLocation,
			String hiringManager, String description, Integer experience) {
		this.opportunityId = id;
		this.role = role;
		this.skills = skills;
		this.publishDate = publishDate;
		this.JoiningLocation = joiningLocation;
		this.HiringManager = hiringManager;
		this.Description = description;
		this.Experience = experience;
	}

	public long getId() {
		return opportunityId;
	}

	public void setId(long id) {
		this.opportunityId = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getJoiningLocation() {
		return JoiningLocation;
	}

	public void setJoiningLocation(String joiningLocation) {
		JoiningLocation = joiningLocation;
	}

	public String getHiringManager() {
		return HiringManager;
	}

	public void setHiringManager(String hiringManager) {
		HiringManager = hiringManager;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Integer getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}
	
	public static Opportunity findByRole(String role) {
		return find("role",role).firstResult();
	}

	
	

}
