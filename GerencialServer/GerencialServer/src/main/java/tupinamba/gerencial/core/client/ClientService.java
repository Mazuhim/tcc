/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

import e_persistence.services.Service;
import e_persistence.services.exceptions.ServiceException;
import tupinamba.gerencial.core.company.Company;
import tupinamba.gerencial.core.product.Product;

/**
 *
 * @author Mazuhim
 */
public interface ClientService extends Service<Client, Integer> {

    public void save(Client entity) throws ServiceException;

    public Appendix findAppendix(Integer idAppendix);

    public Address findAddress(Integer idAddress);
    
    public IdentyDocument findDocumentId(Integer idDocumentId);

    public Phone findPhone(Integer idPhone);
}
