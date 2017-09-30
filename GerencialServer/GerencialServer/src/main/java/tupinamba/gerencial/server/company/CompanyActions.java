/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.company;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import tupinamba.gerencial.server.company.dto.CompanyParam;
import tupinamba.gerencial.webservice.StandardActionProvider;

/**
 *
 * @author Mazuhim
 */
@Path("company")
public class CompanyActions extends StandardActionProvider{
    
    @EJB
    private CompanyActionHandler handler;
    
    @GET
    @Path("find")
    @Produces("application/json")
    public Response find() {
        try {
            return this.createResponse(200, this.handler.find());
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }
    
    @GET
    @Path("find1")
    @Produces("application/json")
    public Response find1() {
        try {
            return this.createResponse(200, this.handler.find1());
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }
    
    @POST
    @Path("save")
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(String json)
    {
        try
        {
            CompanyParam param = this.parseParam(CompanyParam.class, json);
            this.handler.save(param);

            return this.createResponse(200);
        } catch (Throwable e)
        {
            return this.createErrorResponse(e);
        }
    }
}
