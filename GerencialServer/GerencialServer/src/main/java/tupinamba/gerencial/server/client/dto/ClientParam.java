/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.client.dto;

import e_brazil.address.Address;
import java.util.List;

/**
 *
 * @author Mazuhim
 */
public class ClientParam {
    
    private String name;
    private String kinship;
    private boolean holder;
    private int sex;
    private String dateBirth;
    private String cpf;
    private String occupation;
    private Double income;

    private IdentyDocumentDTO document;

    private List<AppendixDTO> appendix;

    private AddressDTO address;

    private List<PhoneDTO> phones;

    public ClientParam() {
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public IdentyDocumentDTO getDocument() {
        return document;
    }

    public void setDocument(IdentyDocumentDTO document) {
        this.document = document;
    }

    public List<AppendixDTO> getAppendix() {
        return appendix;
    }

    public void setAppendix(List<AppendixDTO> appendix) {
        this.appendix = appendix;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }
    
}
