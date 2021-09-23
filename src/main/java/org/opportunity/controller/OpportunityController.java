package org.opportunity.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.opportunity.entity.Audit;
import org.opportunity.entity.Opportunity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Path("/opportunities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OpportunityController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOpportunitites() {
		List<PanacheMongoEntityBase> allOpportunity = Opportunity.listAll();
		return Response.ok(allOpportunity).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public PanacheMongoEntityBase getOpportunityById(@PathParam("id") Long id) {
		return Opportunity.findById(id);
	}
	
	@GET
	@Path("/role/{role}")
	@Produces(MediaType.APPLICATION_JSON)
	public Opportunity getOpportunityByRole(@PathParam("role") String role) {
		return Opportunity.findByRole(role);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOpportunityById(@PathParam("id") Long id) {
		Opportunity opportunity = new Opportunity();
		 String opportunity_INSHORT = opportunity.getRole()+" opportunity created by "+opportunity.getHiringManager()+" on "+
	                opportunity.getPublishDate()+" is successfully deleted";

	        Audit audit = new Audit();
	        Date modifiedOn = new Date();
	        audit.setOpportunityId(opportunity.getId());
	        audit.setAction("DELETED");
	        audit.setRole(opportunity.getRole());
	        audit.setLocation(opportunity.getJoiningLocation());
	        audit.setModifiedBy(opportunity.getHiringManager());
	        audit.setCreatedOn(opportunity.getPublishDate());
	        audit.setModifiedOn(modifiedOn);
	        audit.persist();
	        Opportunity.deleteById(id);
	        Map<String , Boolean> response = new HashMap<>();
	        response.put(opportunity_INSHORT, Boolean.TRUE);

	        return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOpportunity(Opportunity opportunity) {
		Audit audit = new Audit();
		audit.setOpportunityId(opportunity.getId());
        audit.setAction("CREATED");
        audit.setRole(opportunity.getRole());
        audit.setModifiedBy(opportunity.getHiringManager());
        audit.setLocation(opportunity.getJoiningLocation());
        audit.setCreatedOn(opportunity.getPublishDate());
        audit.setModifiedOn(opportunity.getPublishDate());
        audit.persist();
		opportunity.persist();
		return Response.ok(opportunity).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateOpportunity(@PathParam("id") Long id, Opportunity opportunity) {
		 Audit audit = new Audit();
	     Date modifiedOn = new Date();
	     audit.setOpportunityId(opportunity.getId());
	     audit.setAction("MODIFIED");
	     audit.setRole(opportunity.getRole());
	     audit.setModifiedBy(opportunity.getHiringManager());
	     audit.setLocation(opportunity.getJoiningLocation());
	     audit.setCreatedOn(opportunity.getPublishDate());
	     audit.setModifiedOn(modifiedOn);
	     opportunity.update();
	     return Response.ok(opportunity).build();
	}
	
}
	
	

