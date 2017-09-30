/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.company;

import e_persistence.services.Service;
import e_persistence.services.exceptions.ServiceException;
import tupinamba.gerencial.core.product.Product;

/**
 *
 * @author Mazuhim
 */
public interface CompanyService extends Service<Company, Integer> {

    public void save(Company entity) throws ServiceException;

//    @Override
//    public void create(Company entity) throws ServiceException;
//
//    public List<Product> findProducts(int idCompany);
//    
    public Product findProduct(int idProduct);
}
