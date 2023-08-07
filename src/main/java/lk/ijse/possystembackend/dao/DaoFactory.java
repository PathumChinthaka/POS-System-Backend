package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.possystembackend.dao.utill.DaoTypes;

public class DaoFactory {
    private static DaoFactory daoFactory;

    public synchronized static DaoFactory getInstance(){
        return daoFactory==null ? daoFactory= new DaoFactory() :daoFactory;
    }

    public <T extends SuperDAO> T getDao(DaoTypes types){
        switch (types){
            case CUSTOMER_DAO:
                return (T) new CustomerDaoImpl();
            default:
                throw new RuntimeException("Error: Invalid DAO Type");
        }
    }
}
