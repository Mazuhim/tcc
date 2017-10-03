/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.client;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tupinamba.gerencial.server.client.dto.ClientDTO;
import tupinamba.gerencial.server.client.dto.ClientParam;
import tupinamba.gerencial.webservice.StandardActionProvider;

/**
 *
 * @author Mazuhim
 */
@Path("client")
public class ClientActions extends StandardActionProvider {

    @EJB
    private ClientActionHandler handler;

    @GET
    @Path("find")
    @Produces("application/json")
    public Response find() {
        try {
            return this.createResponse(200, this.handler.findClientsResponses());
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }

    @POST
    @Path("save")
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(String json) {
        try {
            ClientParam param = this.parseParam(ClientParam.class, json);
            this.handler.save(param);

            return this.createResponse(200);
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }

    @GET
    @Path("{idClient}/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@PathParam("idClient") Integer idClient) {
        try {
            return this.createResponse(200, this.handler.getData(idClient));
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }

    @PUT
    @Path("update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(String json) {
        try {
            ClientDTO param = this.parseParam(ClientDTO.class, json);
            this.handler.updateClient(param);

            return this.createResponse(200);
        } catch (Throwable e) {
            return this.createErrorResponse(e);
        }
    }
}
