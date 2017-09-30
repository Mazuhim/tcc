/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.core.client;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Mazuhim
 */
@Entity
@Table(name = "appendix")
public class Appendix implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_appendix")
    private int idAppendix;
    private String name;
//    @Lob
//    private byte[] file;
    private long size;
    
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id_client", nullable = false)
    @ForeignKey(name = "fk_client_id")
    private Client client;

    public Appendix() {
    }

    public int getIdAppendix() {
        return idAppendix;
    }

    public void setIdAppendix(int idAppendix) {
        this.idAppendix = idAppendix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public byte[] getFile() {
//        return file;
//    }
//
//    public void setFile(byte[] file) {
//        this.file = file;
//    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
