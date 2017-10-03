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
public class ClientResponse {
    
     private int idClient;
    private String name;
    private String kinship;
    private boolean holder;
    private String dateBirth;
    private String creationDate;
    private String occupation;

    public ClientResponse(int idClient, String name, String kinship, boolean holder, String dateBirth, String creationDate, String occupation) {
        this.idClient = idClient;
        this.name = name;
        this.kinship = kinship;
        this.holder = holder;
        this.dateBirth = dateBirth;
        this.creationDate = creationDate;
        this.occupation = occupation;
    }

    public ClientResponse() {
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
