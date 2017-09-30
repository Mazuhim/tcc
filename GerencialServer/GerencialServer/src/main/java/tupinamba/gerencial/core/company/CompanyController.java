/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.company;

import e_persistence.services.exceptions.ServiceException;
import e_tools.time.TimeToolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tupinamba.gerencial.core.product.Product;
import tupinamba.gerencial.persistence.ServiceFactory;
import tupinamba.gerencial.server.company.dto.CompanyDTO;
import tupinamba.gerencial.server.company.dto.ProductDTO;

/**
 *
 * @author Mazuhim
 */
public class CompanyController implements AutoCloseable {

    private List<Company> entities;
    private List<Company> selectedEntities;
    private Company entity;
    private CompanyService service;

    public CompanyController() {
        this.service = ServiceFactory.openCompanyService();
        this.entities = new ArrayList<>();
        this.selectedEntities = new ArrayList<>();
    }

    public boolean load() {
        this.entities = service.findAll();
        return this.entities != null;
    }

    public void newEntity() {
        this.entity = new Company();
        this.entity.setCreationDate(new Date());

        this.entities.add(entity);

        this.setSelectedEntity(entity);
    }

    public List<Company> getEntities() {
        return entities;
    }

    public void setEntities(List<Company> entities) {
        this.entities = entities;
    }

    public List<Company> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<Company> selectedEntities) {
        this.selectedEntities = selectedEntities;
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }
    
    public void setSelectedEntities1(List<Company> selectedEntities) {
        this.selectedEntities = selectedEntities;
        
//        for (Company entity1 : this.selectedEntities) {
//            for (Product product : entity1.getProducts()) {
//                System.out.println(product.getName());
//            }
//        }
        
        this.entity = selectedEntities.isEmpty() ? null : selectedEntities.get(0);
    }

    public void setSelectedEntity(Company company) {
        List<Company> companies = new ArrayList<>();
        companies.add(company);

        this.setSelectedEntities(companies);
    }

    public void selectAll() {
        this.setSelectedEntities(new ArrayList(this.entities));
    }
    
    public void selectAll1() {
        this.setSelectedEntities1(new ArrayList(this.entities));
    }
    
    public Company getEntity() {
        return entity;
    }

    public void setEntity(Company entity) {
        this.entity = entity;
    }

    public void save() throws ServiceException {
        this.service.save(this.entity);
    }

    public CompanyService getService() {
        return service;
    }

    public void setService(CompanyService service) {
        this.service = service;
    }

    @Override
    public void close() throws Exception {
        this.service.close();
    }

    public int getIdCompany() {
        return entity.getIdCompany();
    }

    public void setIdCompany(int idCompany) {
        entity.setIdCompany(idCompany);
    }

    public String getNameCompany() {
        return entity.getNameCompany();
    }

    public void setNameCompany(String nameCompany) {
        entity.setNameCompany(nameCompany);
    }

    public String getCnpj() {
        return entity.getCnpj();
    }

    public void setCnpj(String cnpj) {
        entity.setCnpj(cnpj);
    }

    public Date getCreationDate() {
        return entity.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        entity.setCreationDate(creationDate);
    }

//    public byte[] getPicture() {
//        return entity.getPicture();
//    }
//
//    public void setPicture(byte[] picture) {
//        entity.setPicture(picture);
//    }

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

    public List<Product> getProducts() {
        return entity.getProducts();
    }

    public void setProducts(List<Product> products) {
        entity.setProducts(products);
    }

    public void addProduct(ProductDTO productDTO) {
        Product product;
        if (productDTO.getIdProduct() == null || productDTO.getIdProduct() == 0) {
            product = new Product();
            product.setName(productDTO.getName());
        } else {
            product = this.service.findProduct(productDTO.getIdProduct());
        }
        entity.addProduct(product);
    }

    public void removeProduct(int idProduct) {
        entity.removeProduct(idProduct);
    }
    
    public CompanyDTO toDTO(Company company)
    {
        CompanyDTO dTO = new CompanyDTO();
        dTO.setIdCompany(company.getIdCompany());
        dTO.setActive(company.getActive());
        dTO.setCnpj(company.getCnpj());
        dTO.setCreationDate(TimeToolkit.toString(company.getCreationDate()));
        dTO.setDeleteDate("");
        dTO.setNameCompany(company.getNameCompany());
//        dTO.setPicture(company.getPicture());
        dTO.setProducts(this.parseProductDTO(company.getProducts()));
        return dTO;
    }

    private List<ProductDTO> parseProductDTO(List<Product> products) {
        List<ProductDTO> dTOs = new ArrayList<>();
        
        products.forEach((p) -> {
            ProductDTO dTO = new ProductDTO();
            dTO.setIdProduct(p.getIdProduct());
            dTO.setName(p.getName());
            
            dTOs.add(dTO);
        });
        
        return dTOs;
    }
}
