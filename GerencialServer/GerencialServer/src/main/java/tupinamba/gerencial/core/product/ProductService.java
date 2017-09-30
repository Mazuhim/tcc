/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.product;

import e_persistence.services.Service;
import e_persistence.services.exceptions.ServiceException;

/**
 *
 * @author Mazuhim
 */
public interface ProductService extends Service<Product, Integer>{
    
       public void save(Product entity) throws ServiceException;    

}
