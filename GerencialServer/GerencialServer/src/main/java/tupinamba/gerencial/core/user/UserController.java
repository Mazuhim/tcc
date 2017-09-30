/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tupinamba.gerencial.core.user;

import e_persistence.services.exceptions.ServiceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tupinamba.gerencial.persistence.ServiceFactory;

/**
 *
 * @author Thiago Mazuhim Costa
 */
public class UserController implements AutoCloseable
{
    private List<User> entities;
    private List<User> selectedEntities;
    private User entity;
    private UserService service;

    public UserController()
    {
        this.service = ServiceFactory.openUserService();
        this.entities = new ArrayList<>();
        this.selectedEntities = new ArrayList<>();
    }

    public boolean load()
    {
        this.entities = service.findAll();
        return this.entities != null;
    }

    public void newEntity()
    {
        this.entity = new User();
        this.entity.setCreationDate(new Date());

        this.entities.add(entity);

        this.setSelectedEntity(entity);
    }

    public List<User> getEntities()
    {
        return entities;
    }

    public void setEntities(List<User> entities)
    {
        this.entities = entities;
    }

    public List<User> getSelectedEntities()
    {
        return selectedEntities;
    }

    public void setSelectedEntities(List<User> selectedEntities)
    {
        this.selectedEntities = selectedEntities;
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }

    public void setSelectedEntity(User user)
    {
        List<User> users = new ArrayList<>();
        users.add(user);

        this.setSelectedEntities(users);
    }

    public void selectAll()
    {
        this.setSelectedEntities(new ArrayList(this.entities));
    }

    public User getEntity()
    {
        return entity;
    }

    public void setEntity(User entity)
    {
        this.entity = entity;
    }

    public UserService getService()
    {
        return service;
    }

    public void setService(UserService service)
    {
        this.service = service;
    }
//-----------------------

    public int getIdUser() {
        return entity.getIdUser();
    }

    public void setIdUser(int idUser) {
        entity.setIdUser(idUser);
    }

    public String getName() {
        return entity.getName();
    }

    public void setName(String name) {
        entity.setName(name);
    }

    public Boolean getAgnt() {
        return entity.getAgnt();
    }

    public void setAgnt(Boolean agnt) {
        entity.setAgnt(agnt);
    }

    public String getEmail() {
        return entity.getEmail();
    }

    public void setEmail(String email) {
        entity.setEmail(email);
    }

    public Date getCreationDate() {
        return entity.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        entity.setCreationDate(creationDate);
    }

    public String getPhone() {
        return entity.getPhone();
    }

    public void setPhone(String phone) {
        entity.setPhone(phone);
    }

    public Boolean getActive() {
        return entity.getActive();
    }

    public void setActive(Boolean active) {
        entity.setActive(active);
    }

    public Date getDeleteDate() {
        return entity.getDeleteDate();
    }

    public void setDeleteDate(Date deleteDate) {
        entity.setDeleteDate(deleteDate);
    }
    //--------------

    public void save() throws ServiceException
    {
        this.service.save(this.entity);
    }
    @Override
    public void close() throws Exception
    {
        this.service.close();
    }
}
