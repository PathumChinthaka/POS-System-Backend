package lk.ijse.possystembackend.dao.custom.impl;

import lk.ijse.possystembackend.dao.CrudDAO;
import lk.ijse.possystembackend.entity.SuperEntity;
import org.hibernate.Session;

public class CustomerDaoImpl implements CrudDAO {

    @Override
    public boolean saveData(SuperEntity entity, Session session) {
        return false;
    }

    @Override
    public boolean updateData(SuperEntity entity, Session session) {
        return false;
    }

    @Override
    public SuperEntity showData(SuperEntity entity, Session session) {
        return null;
    }

    @Override
    public boolean deleteData(SuperEntity entity, Session session) {
        return false;
    }
}
