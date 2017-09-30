/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Mazuhim
 */
@Entity
@Table(name = "identy_document")
public class IdentyDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_identy_document")
    private int idIdentyDocument;
    private String rg;
    @Column(name = "registry_entity")
    private String registryEntity;
    @Column(name = "expedition_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expeditionDate;
    
    @OneToOne
    private Client client;

    public IdentyDocument() {
    }

    public int getIdIdentyDocument() {
        return idIdentyDocument;
    }

    public void setIdIdentyDocument(int idIdentyDocument) {
        this.idIdentyDocument = idIdentyDocument;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRegistryEntity() {
        return registryEntity;
    }

    public void setRegistryEntity(String registryEntity) {
        this.registryEntity = registryEntity;
    }

    public Date getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
