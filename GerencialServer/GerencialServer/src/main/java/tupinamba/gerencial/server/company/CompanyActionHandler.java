/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.server.company;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import tupinamba.gerencial.core.company.Company;
import tupinamba.gerencial.core.company.CompanyController;
import tupinamba.gerencial.core.product.Product;
import tupinamba.gerencial.server.company.dto.CompanyDTO;
import tupinamba.gerencial.server.company.dto.CompanyParam;
import tupinamba.gerencial.server.company.dto.ProductDTO;

/**
 *
 * @author Mazuhim
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class CompanyActionHandler {

    public List<CompanyDTO> find() throws Exception {
        try (CompanyController controller = new CompanyController()) {
            controller.load();
            controller.selectAll();
//            Product p = controller.getProducts().get(0);

            List<CompanyDTO> companies = new ArrayList<>();
            controller.getEntities().forEach((c) -> {
                companies.add(controller.toDTO(c));
            });
            return companies;
        }
    }

    public List<CompanyDTO> find1() throws Exception {
        try (CompanyController controller = new CompanyController()) {
            controller.load();
            controller.selectAll1();
//            Product p = controller.getProducts().get(0);

            List<CompanyDTO> companies = new ArrayList<>();
            controller.getEntities().forEach((c) -> {
                companies.add(controller.toDTO(c));
            });
            return companies;
        }
    }

    public void save(CompanyParam param) throws Exception {

        try (CompanyController controller = new CompanyController()) {
            controller.newEntity();
            controller.setActive(param.getActive());
            controller.setCnpj(param.getCnpj());
            controller.setNameCompany(param.getName());
//            controller.setPicture(param.getPicture());

            List<ProductDTO> productsDTOs = param.getProducts();
            if (productsDTOs != null) {
                for (ProductDTO dTO : productsDTOs) {
                    controller.addProduct(dTO);
                }
            }

            controller.save();
        }
    }
}
