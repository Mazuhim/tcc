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
public class PhoneDTO {
    
    private Integer idPhone;
    private String number;
    private String ddd;
    private boolean mainPhone;

    public PhoneDTO() {
    }

    public PhoneDTO(int idPhone, String number, String ddd, boolean mainPhone) {
        this.idPhone = idPhone;
        this.number = number;
        this.ddd = ddd;
        this.mainPhone = mainPhone;
    }

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public boolean isMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(boolean mainPhone) {
        this.mainPhone = mainPhone;
    }
}
