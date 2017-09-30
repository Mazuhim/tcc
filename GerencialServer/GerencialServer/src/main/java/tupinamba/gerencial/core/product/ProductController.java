/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.product;

import e_persistence.services.exceptions.ServiceException;
import java.util.ArrayList;
import java.util.List;
import tupinamba.gerencial.persistence.ServiceFactory;

/**
 *
 * @author Mazuhim
 */
public class ProductController implements AutoCloseable{

    private List<Product> entities;
    private List<Product> selectedEntities;
    private Product entity;
    private ProductService service;

    public ProductController() {
        this.service = ServiceFactory.openProductService();
        this.entities = new ArrayList<>();
        this.selectedEntities = new ArrayList<>();
    }

    public boolean load() {
        this.entities = service.findAll();
        return this.entities != null;
    }

    public void newEntity() {
        this.entity = new Product();
        this.entities.add(entity);
        this.setSelectedEntity(entity);
    }

    public List<Product> getEntities() {
        return entities;
    }

    public void setEntities(List<Product> entities) {
        this.entities = entities;
    }

    public List<Product> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<Product> selectedEntities) {
        this.selectedEntities = selectedEntities;
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }

    public void setSelectedEntity(Product product) {
        List<Product> products = new ArrayList<>();
        products.add(product);

        this.setSelectedEntities(products);
    }

    public void selectAll() {
        this.setSelectedEntities(new ArrayList(this.entities));
    }

    public Product getEntity() {
        return entity;
    }

    public void setEntity(Product entity) {
        this.entity = entity;
    }

    public void save() throws ServiceException {
        this.service.save(this.entity);
    }

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    @Override
    public void close() throws Exception {
        this.service.close();
    }

    public int getIdProduct() {
        return entity.getIdProduct();
    }

    public void setIdProduct(int idProduct) {
        entity.setIdProduct(idProduct);
    }

    public String getName() {
        return entity.getName();
    }

    public void setName(String name) {
        entity.setName(name);
    }
    
    
}
