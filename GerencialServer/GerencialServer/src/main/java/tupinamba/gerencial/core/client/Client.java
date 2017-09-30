/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mazuhim
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private int idClient;
    private String name;
    private String kinship;
    private boolean holder;
    private int sex;
    @Column(name = "date_birth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private String cpf;
    private String occupation;
    private double income;

    @JoinColumn(unique = true)
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private IdentyDocument document;

    @OneToMany(mappedBy = "client", targetEntity = Appendix.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Appendix> appendixList;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "client", targetEntity = Phone.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Phone> phones;

//    @OneToMany(mappedBy = "client", targetEntity = Appendix.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Policy> policies;
    public Client() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }

    public boolean isHolder() {
        return holder;
    }

    public void setHolder(boolean holder) {
        this.holder = holder;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public IdentyDocument getDocument() {
        return document;
    }

    public void setDocument(IdentyDocument document) {
        this.document = document;
    }

    public List<Appendix> getAppendixList() {
        if (appendixList == null) {
            appendixList = new ArrayList<>();
        }
        return appendixList;
    }

    public void setAppendixList(List<Appendix> appendix) {
        this.appendixList = appendix;
    }

    public void addAppendix(Appendix appendix) {
        appendix.setClient(this);
        this.getAppendixList().add(appendix);
    }
    
    public void removeAppendix(int idAppendix) {
        this.getAppendixList().remove(idAppendix);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        if (this.phones == null) {
            this.phones = new ArrayList<>();
        }
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    
    public void addPhone(Phone phone)
    {
        phone.setClient(this);
       this.getPhones().add(phone);
    }
    
    public void removePhone(int idPhone){
        this.getPhones().remove(idPhone);
    }

//    public List<Policy> getPolicies() {
//        return policies;
//    }
//
//    public void setPolicies(List<Policy> policies) {
//        this.policies = policies;
//    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
