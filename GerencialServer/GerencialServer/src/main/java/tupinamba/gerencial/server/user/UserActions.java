/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.user;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import tupinamba.gerencial.webservice.StandardActionProvider;

/**
 *
 * @author Mazuhim
 */
@Path("user")
public class UserActions extends StandardActionProvider {

    @EJB
    UserActionHandler handler;

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
}
