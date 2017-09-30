/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupinamba.gerencial.persistence;

import e_persistence.session.DefaultSession;
import e_persistence.session.Session;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tupinamba.gerencial.core.client.ClientService;
import tupinamba.gerencial.core.client.ClientServiceImp;
import tupinamba.gerencial.core.company.CompanyService;
import tupinamba.gerencial.core.company.CompanyServiceImp;
import tupinamba.gerencial.core.product.ProductService;
import tupinamba.gerencial.core.product.ProductServiceImp;
import tupinamba.gerencial.core.user.UserService;
import tupinamba.gerencial.core.user.UserServiceImp;

/**
 *
 * @author Pablo JS dos Santos
 */
public class ServiceFactory
{
    private static HashMap<String, EntityManagerFactory> cache;

    static
    {
        cache = new HashMap<>();
    }

    private static EntityManager getEntityManager(String jndi)
    {
        EntityManagerFactory factory = cache.get(jndi);

        if (factory == null || !factory.isOpen())
        {
            HashMap<String, String> map = new HashMap<>();
            map.put("hibernate.connection.datasource", jndi);
//        map.put("hibernate.connection.provider_class", HibernateConnectionProvider.class.getName());

            factory = Persistence.createEntityManagerFactory("GerencialServerPU", map);
            cache.put(jndi, factory);
        }

        try
        {
            return factory.createEntityManager();
        } catch (Exception e)
        {
            HashMap<String, String> map = new HashMap<>();
            map.put("hibernate.connection.datasource", jndi);

            factory = Persistence.createEntityManagerFactory("GerencialServerPU", map);
            cache.put(jndi, factory);

            return factory.createEntityManager();
        }
    }

    public static Session openCentralSession()
    {
        return new DefaultSession(getEntityManager("java:jboss/datasources/gerencial_server"));
    }

//    public static RemoteTaskService openRemoteTaskService()
//    {
//        return new RemoteTaskServiceImp(openCentralSession());
//    }

    public static UserService openUserService() {
        return new UserServiceImp(openCentralSession());
    }

    public static CompanyService openCompanyService() {
        return new CompanyServiceImp(openCentralSession());
    }

    public static ProductService openProductService() {
        return new ProductServiceImp(openCentralSession());
    }

//    public static AgentService openAgentService() {
//        return new AgentServiceImp(openCentralSession());
//    }
    public static ClientService openClientService() {
        return new ClientServiceImp(openCentralSession());
    }
}