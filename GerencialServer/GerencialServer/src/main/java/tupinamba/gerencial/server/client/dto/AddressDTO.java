/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.client.dto;

import e_exceptions.Issue;
import e_exceptions.IssueException;
import e_tools.text.Strings;
import e_tools.text.TextFormat;
import java.util.Objects;

/**
 *
 * @author Mazuhim
 */
public class AddressDTO
{
    public static final String COUNTRY_CODE = "1058";
    public static final String COUNTRY_NAME = "BRASIL";
    public static final String CEP_FORMAT = "#####-###";

    private Integer idAddress;
    private String cep;
    private String mailBox;
    private long number;
    private String complement;
    private String street;
    private String neighborhood;
    private String city;
    private String uf;

    public AddressDTO()
    {
    }

    public String getComplement()
    {
        return complement;
    }

    public void setComplement(String complement)
    {
        this.complement = complement;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        try
        {
            TextFormat formatter = new TextFormat("#####-###");
            this.cep = formatter.format(Strings.getNumbers(cep));
        } catch (Exception e)
        {
            this.cep = null;
        }
    }

    public String getMailBox()
    {
        return mailBox;
    }

    public void setMailBox(String mailBox)
    {
        this.mailBox = mailBox;
    }

    public long getNumber()
    {
        return number;
    }

    public void setNumber(long number)
    {
        this.number = number;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getUf()
    {
        return this.uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getNeighborhood()
    {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood)
    {
        this.neighborhood = neighborhood;
    }

    /**
     * Returns the name of the street followed by the number. By default returns
     * --,--
     * <p>
     *
     * @return street, number
     */
    public String getSimpleAddress()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Strings.isValid(this.street) ? this.street : "--");
        builder.append(", ");
        builder.append(Strings.isValid(Long.toString(this.number)) ? this.number : "--");

        return builder.toString();
    }

    /**
     * Returns the UF folowed by the name of the city
     * <p>
     *
     * @return UF - City
     */
    public String getUfAndCity()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(Strings.isValid(this.uf) ? this.uf : "--");
        builder.append(" - ");
        builder.append(Strings.isValid(this.city) ? this.city : "--");

        return builder.toString();
    }

    public String getStreetNumberNeighborhood()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Strings.isValid(this.street) ? this.street : "--");
        builder.append(", ");
        builder.append(Strings.isValid(Long.toString(this.number)) ? this.number : "S/N");
        builder.append(" - ");
        builder.append(Strings.isValid(this.neighborhood) ? this.neighborhood : "--");

        return builder.toString();
    }

    public String getStreetNumberComplementNeighborhood()
    {
        String streetNumberComplement = this.getStreetNumberComplement();
        StringBuilder builder = new StringBuilder(streetNumberComplement);

        builder.append(" - ");
        builder.append(Strings.isValid(this.neighborhood) ? this.neighborhood : "--");

        return builder.toString();
    }

    public String getCityUf()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(Strings.isValid(this.city) ? this.city : "--");
        builder.append(" - ");
        builder.append(Strings.isValid(this.uf) ? this.uf : "--");

        return builder.toString();
    }

    public String getStreetNumberComplementNeighborhoodCityUf()
    {
        String streetNumberComplementNeighborhood = this.getStreetNumberComplementNeighborhood();
        StringBuilder builder = new StringBuilder(streetNumberComplementNeighborhood);

        builder.append(" - ");
        builder.append(Strings.isValid(this.city) ? this.city : "--");
        builder.append(", ");
        builder.append(Strings.isValid(this.uf) ? this.uf : "--");

        return builder.toString();
    }

    public String getStreetNumberComplementNeighborhoodCity()
    {
        String streetNumberComplementNeighborhood = this.getStreetNumberComplementNeighborhood();
        StringBuilder builder = new StringBuilder(streetNumberComplementNeighborhood);

        builder.append(" - ");
        builder.append(Strings.isValid(this.city) ? this.city : "--");

        return builder.toString();
    }

    public String getCepCityUf()
    {
        String cityUf = this.getCityUf();

        StringBuilder builder = new StringBuilder();

        builder.append(Strings.isValid(this.cep) ? this.cep : "--");
        builder.append(" - ");
        builder.append(cityUf);

        return builder.toString();
    }

    public String getStreetNumberComplement()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Strings.isValid(this.street) ? this.street : "--");
        builder.append(", ");

        builder.append(Strings.isValid(Long.toString(this.number)) ? this.number : "S/N");

        if (Strings.isValid(this.complement))
        {
            builder.append(" (");
            builder.append(this.complement);
            builder.append(")");
        }

        return builder.toString();
    }

    public String getNeighborhoodCityUf()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(Strings.isValid(this.neighborhood) ? this.neighborhood : "--");
        builder.append(" - ");
        builder.append(Strings.isValid(this.city) ? this.city : "--");
        builder.append(" - ");
        builder.append(Strings.isValid(this.uf) ? this.uf : "--");

        return builder.toString();
    }

    public boolean isEmpty()
    {
        return !Strings.isValid(this.cep)
                && !Strings.isValid(this.mailBox)
                && !Strings.isValid(this.complement)
                && !Strings.isValid(Long.toString(this.number))
                && !Strings.isValid(this.street)
                && !Strings.isValid(this.neighborhood)
                && !Strings.isValid(this.city)
                && !Strings.isValid(this.uf);
    }

    public void validate() throws IssueException
    {
        IssueException exception = new IssueException();

        if (!Strings.isValid(this.uf))
        {
            exception.addIssue(new Issue("UF não informada"));
        }

        if (!Strings.isValid(this.city))
        {
            exception.addIssue(new Issue("Cidade não informada"));
        }

        if (!Strings.isValid(this.neighborhood))
        {
            exception.addIssue(new Issue("Bairro não informado"));
        }

        if (!Strings.isValid(this.street))
        {
            exception.addIssue(new Issue("Logradouro não informado"));
        }

        if (!Strings.isValid(Long.toString(this.number)))
        {
            exception.addIssue(new Issue("Número não informado"));
        }

        if (!Strings.isValid(this.cep))
        {
            exception.addIssue(new Issue("CEP não informado"));
        }

        if (!exception.isEmpty())
        {
            throw exception;
        }
    }

    public boolean deepEquals(AddressDTO address)
    {
        if (address == null)
        {
            return false;
        }

        return Objects.equals(this.uf, address.uf)
                && Objects.equals(this.city, address.city)
                && Objects.equals(this.neighborhood, address.neighborhood)
                && Objects.equals(this.street, address.street)
                && Objects.equals(this.number, address.number)
                && Objects.equals(this.complement, address.complement)
                && Objects.equals(this.cep, address.cep)
                && Objects.equals(this.mailBox, address.mailBox);
    }

    /**
     * Returns this address as String:
     * Furriel Luíz Antônio de Vargas, 250 (Sala 1302)
     * Porto Alegre - RS
     * CEP: 90470-130, Cx. Postal: 123456
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getStreetNumberComplement()).append("\n");
        builder.append(this.getNeighborhoodCityUf()).append("\n");
        builder.append("CEP: ").append(Strings.getString(this.getCep(), ""));

        if (Strings.isValid(this.mailBox))
        {
            builder.append(", Cx. Postal: ");
            builder.append(this.mailBox);
        }

        return builder.toString();
    }

    public String getGoogleMapsURL()
    {
        StringBuilder builder = new StringBuilder("http://maps.google.com/?q=");
        builder.append("Brasil+");
        builder.append(this.city);
        builder.append("+");
        builder.append(this.neighborhood);
        builder.append("+");
        builder.append(this.street);
        builder.append(",");
        builder.append(this.number);

        return builder.toString().replaceAll(" ", "%20");
    }

    public static void main(String[] args)
    {
        AddressDTO address = new AddressDTO();
        address.setUf("RS");
        address.setCity("Porto Alegre");
        address.setComplement("Sala 1302");
        address.setNeighborhood("Bela Vista");
        address.setNumber(250);
        address.setStreet("Furriel Luíz Antônio de Vargas");
        address.setCep("90470130");
        address.setMailBox("123456");

        System.out.println("address = \n" + address);
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
    
}
