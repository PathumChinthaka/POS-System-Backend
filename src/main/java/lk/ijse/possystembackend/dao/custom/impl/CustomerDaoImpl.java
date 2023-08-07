package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.CrudDAO;
import lk.ijse.possystembackend.dao.custom.CustomerDAO;
import lk.ijse.possystembackend.entity.Customer;
import lk.ijse.possystembackend.entity.SuperEntity;
import org.hibernate.Session;

public class CustomerDaoImpl implements CustomerDAO {

    @Override
    public boolean saveData(Customer entity, Session session) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean updateData(Customer entity, Session session) {
        return false;
    }

    @Override
    public Customer showData(Customer entity, Session session) {
        return null;
    }

    @Override
    public boolean deleteData(Customer entity, Session session) {
        return false;
    }
}
