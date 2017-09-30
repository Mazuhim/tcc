/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.user;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import tupinamba.gerencial.core.user.User;
import tupinamba.gerencial.core.user.UserController;

/**
 *
 * @author Mazuhim
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class UserActionHandler {
    
    public List<User> find() throws Exception
    {
        try (UserController controller = new UserController())
        {
            controller.load();
            controller.selectAll();

            return controller.getEntities();
        }
    }
}
