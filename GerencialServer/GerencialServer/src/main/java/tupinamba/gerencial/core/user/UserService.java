/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tupinamba.gerencial.core.user;

import e_persistence.services.Service;
import e_persistence.services.exceptions.ServiceException;
import java.util.List;


/**
 *
 * @author Thiago Mazuhim Costa
 */
public interface UserService extends Service<User, Integer>
{
    public void save(User entity) throws ServiceException;
}
