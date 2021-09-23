package org.opportunity.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "Audit")
public class Audit extends PanacheMongoEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@BsonProperty("audit_id")
	public long auditId;
	
	@BsonProperty("opportunity_id")
	Long opportunityId;
	
	@BsonProperty("action")
	String action;
	
	@BsonProperty("modified_by")
	String modifiedBy;
	
	@BsonProperty("role")
	String role;
	
	@BsonProperty("location")
	String location;
	
	@BsonProperty("created_on")
	Date createdOn;
	
	@BsonProperty("modified_on")
	Date modifiedOn;

	public Audit() {
	}

	public Audit(long auditId, Long opportunityId, String action, String modifiedBy, String role, String location,
			Date createdOn, Date modifiedOn) {
		this.auditId = auditId;
		this.opportunityId = opportunityId;
		this.action = action;
		this.modifiedBy = modifiedBy;
		this.role = role;
		this.location = location;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public Long getOpportunityId() {
		return opportunityId;
	}

	public void setOpportunityId(Long opportunityId) {
		this.opportunityId = opportunityId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	
	
	
	
	
}
