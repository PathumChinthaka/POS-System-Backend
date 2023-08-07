package lk.ijse.possystembackend.service.custom.impl;

import lk.ijse.possystembackend.dao.DaoFactory;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.dao.utill.DaoTypes;
import lk.ijse.possystembackend.db.FactoryConfiguration;
import lk.ijse.possystembackend.dto.CustomerDTO;
import lk.ijse.possystembackend.dto.SuperDTO;
import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.service.SuperService;
import lk.ijse.possystembackend.service.custom.CustomerService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerDAO customerDAO;

public CustomerServiceImpl(){
    customerDAO= DaoFactory.getInstance().getDao(DaoTypes.CUSTOMER_DAO);
}

    @Override
    public boolean saveData(CustomerDTO dto) {

        Customer customer=new Customer();
        customer.setCusId(dto.getCusId());
        customer.setCusName(dto.getCusName());
        customer.setAddress(dto.getAddress());
        customer.setNic(dto.getNic());
        customer.setEmail(dto.getEmail());
        customer.setContact(dto.getContact());

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try(session){
            customerDAO.saveData(customer,session);
            transaction.commit();
            System.out.println("customer save transaction ok");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public boolean updateData(CustomerDTO dto) {
        return false;
    }

    @Override
    public CustomerDTO showData(CustomerDTO dto) {
        return null;
    }

    @Override
    public boolean deleteData(CustomerDTO dto) {
        return false;
    }

}
