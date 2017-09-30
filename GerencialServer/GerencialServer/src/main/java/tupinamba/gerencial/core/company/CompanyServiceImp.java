/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.company;

import e_persistence.services.exceptions.ServiceException;
import e_persistence.session.Session;
import tupinamba.gerencial.core.product.Product;
import tupinamba.gerencial.persistence.GerencialServerService;

/**
 *
 * @author Mazuhim
 */
public class CompanyServiceImp extends GerencialServerService<Company, Integer> implements CompanyService {

    public CompanyServiceImp(Session session) {
        super(Company.class, session);

    }
    
    @Override
    public void save(Company entity) throws ServiceException
    {
        this.begin();

        try
        {
            Session session = this.getSession();

            if (entity.getIdCompany()== 0)
            {
                session.create(entity);
            } else
            {
                session.edit(entity);
            }

            session.flush();
            for (Product product : entity.getProducts()) {
                session.create(product);
                session.flush();
            }
        } catch (Exception e)
        {
            this.rollback(e);
        }

        this.commit();
    }

//    @Override
//    public void save(Company entity) throws ServiceException {
//        this.begin();
//
//        try {
//            Session session = this.getSession();
//
//            if (entity.getIdCompany() == 0) {
//                session.create(entity);
//            } else {
//                session.edit(entity);
//            }
//
//            session.flush();
//        } catch (Exception e) {
//            this.rollback(e);
//        }
//
//        this.commit();
//    }
//    @Override
//    public List<Product> findProducts(int idCompany) {
//        Query query = this.getSession().createQuery(QueryType.JPQL);
//        query.setQuery("SELECT p FROM Product p WHERE p.idCompany = :idCompany");
//        query.putParameter("idCompany", idCompany);
//
//        return query.getResultList();
//    }

//    @Override
//    public void create(Company entity) throws ServiceException {
//        this.begin();
//
//        try {
//            List<Product> products = entity.getProducts();
//
//            Session session = this.getSession();
//            session.create(entity);
//            session.flush();
//
//            for (Product product : products) {
//                product.setIdCompany(entity.getIdCompany());
//                if (product.getIdProduct() != 0) {
//                    session.merge(product);
//
//                } else {
//                    session.create(product);
//                }
//                session.flush();
//            }
//        } catch (Exception e) {
//            this.rollback(e);
//        }
//
//        this.commit();
//    }

    @Override
    public Product findProduct(int idProduct) {
//        Query query = this.getSession().createQuery(QueryType.JPQL);
//        query.setQuery("SELECT p FROM Product p WHERE p.idProduct = :idProduct");
//        query.putParameter("idProduct", idProduct);
//
//        return query.getSingleResult();
    return this.getSession().find(Product.class, idProduct);
    }

}
