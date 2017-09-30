/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tupinamba.gerencial.core.user;

import e_persistence.services.exceptions.ServiceException;
import e_persistence.session.Session;
import tupinamba.gerencial.persistence.GerencialServerService;


public class UserServiceImp extends GerencialServerService<User, Integer> implements UserService
{
    public UserServiceImp(Session session)
    {
        super(User.class, session);
    }

    @Override
    public void save(User entity) throws ServiceException
    {
         this.begin();

        try
        {
            Session session = this.getSession();

            if (entity.getIdUser() == 0)
            {
                session.create(entity);
            } else
            {
                session.edit(entity);
            }

            session.flush();
        } catch (Exception e)
        {
            this.rollback(e);
        }

        this.commit();
    }

}
