/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

import e_persistence.services.exceptions.ServiceException;
import e_persistence.session.Session;
import tupinamba.gerencial.persistence.GerencialServerService;

/**
 *
 * @author Mazuhim
 */
public class ClientServiceImp extends GerencialServerService<Client, Integer> implements ClientService {

    public ClientServiceImp(Session session) {
        super(Client.class, session);

    }

    @Override
    public void save(Client entity) throws ServiceException {
        this.begin();

        try {
            Session session = this.getSession();

            if (entity.getIdClient() == 0) {
                session.create(entity);
            } else {
                session.edit(entity);
            }

            session.flush();
        } catch (Exception e) {
            this.rollback(e);
        }

        this.commit();
    }

    @Override
    public Appendix findAppendix(Integer idAppendix) {
        return this.getSession().find(Appendix.class, idAppendix);
    }

    @Override
    public Address findAddress(Integer idAddress) {
        return this.getSession().find(Address.class, idAddress);
    }

    @Override
    public IdentyDocument findDocumentId(Integer idDocumentId) {
        return this.getSession().find(IdentyDocument.class, idDocumentId);
    }

    @Override
    public Phone findPhone(Integer idPhone) {
        return this.getSession().find(Phone.class, idPhone);
    }
}
