/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.client.dto;

/**
 *
 * @author Mazuhim
 */
public class AppendixDTO {
    
    private Integer idAppendix;
    private String name;
//    private byte[] file;
    private long size;
    

    public AppendixDTO() {
    }

    public AppendixDTO(Integer idAppendix, String name, long size) {
        this.idAppendix = idAppendix;
        this.name = name;
        this.size = size;
    }

    public Integer getIdAppendix() {
        return idAppendix;
    }

    public void setIdAppendix(Integer idAppendix) {
        this.idAppendix = idAppendix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
