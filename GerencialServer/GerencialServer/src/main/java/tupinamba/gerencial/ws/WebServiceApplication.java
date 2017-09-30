/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.ws;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import tupinamba.gerencial.server.client.ClientActions;
import tupinamba.gerencial.server.company.CompanyActions;
import tupinamba.gerencial.server.user.UserActions;

/**
 *
 * @author Pablo JS dos Santos
 */

@ApplicationPath(value = "")
public class WebServiceApplication extends Application
{
    @Override
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UserActions.class);
        classes.add(CompanyActions.class);
        classes.add(ClientActions.class);
        return classes;
    }
}
