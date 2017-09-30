/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import tupinamba.gerencial.core.product.Product;
import tupinamba.gerencial.persistence.ServiceFactory;

/**
 *
 * @author Mazuhim
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_company")
    private int idCompany;
    @Column(name = "name_company")
    private String nameCompany;
    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "company", targetEntity = Product.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Product> products;

    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
//    @Column(name = "picture")
//    private byte[] picture;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "delete_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deleteDate;

    public Company() {
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Product> getProducts() {
        if (this.products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

//    public List<Product> getProducts() {
//        if (this.products == null) {
//            if (this.idCompany > 0) {
//                try (CompanyService service = ServiceFactory.openCompanyService()) {
//                    this.products = service.findProducts(this.idCompany);
//                }
//            } else {
//                this.products = new ArrayList<>();
//            }
//        }
//
//        return products;
//    }
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        product.setCompany(this);
        this.getProducts().add(product);
    }

    public void removeProduct(int idProduct) {
        this.getProducts().remove(idProduct);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

//    public byte[] getPicture() {
//        return picture;
//    }
//
//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

}
