package org.opportunity.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.opportunity.entity.Audit;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;

@Path("/audit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuditController {

	@GET
	public List<PanacheMongoEntityBase> getAuditOpportunities() {
		return Audit.listAll();
	}
	
}
