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
public class IdentyDocumentDTO {

    private Integer idIdentyDocument;
    private String rg;
    private String registryEntity;
    private String expeditionDate;
    
    public IdentyDocumentDTO() {
    }

    public IdentyDocumentDTO(Integer idIdentyDocument, String rg, String registryEntity, String expeditionDate) {
        this.idIdentyDocument = idIdentyDocument;
        this.rg = rg;
        this.registryEntity = registryEntity;
        this.expeditionDate = expeditionDate;
    }

    public Integer getIdIdentyDocument() {
        return idIdentyDocument;
    }

    public void setIdIdentyDocument(Integer idIdentyDocument) {
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

    public String getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(String expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

}
