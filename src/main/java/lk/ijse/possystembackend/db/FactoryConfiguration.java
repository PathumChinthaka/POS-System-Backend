package lk.ijse.possystembackend.db;

import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.entity.Item;
import lk.ijse.possystembackend.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration instance;
    private SessionFactory factory;

   private FactoryConfiguration(){
        Configuration configure=new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class);
        factory=configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return instance==null ? new FactoryConfiguration() : instance;
    }

    public Session getSession(){
       return factory.openSession();
    }

}
