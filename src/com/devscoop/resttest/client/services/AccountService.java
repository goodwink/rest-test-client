package com.devscoop.resttest.client.services;

import org.codegist.crest.annotate.Consumes;
import org.codegist.crest.annotate.EndPoint;
import org.codegist.crest.annotate.PathParam;
import org.codegist.crest.annotate.Path;

import com.devscoop.resttest.client.models.Account;

@EndPoint("http://10.0.2.2:3000")
@Path("/accounts")
@Consumes("application/json")
public interface AccountService {
	@Path(".json")
	Account[] getAccounts();
	
	@Path("/{id}.json")
	Account getAccount(@PathParam("id") String id);
}
