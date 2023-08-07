package lk.ijse.possystembackend.service;

import lk.ijse.possystembackend.service.custom.impl.CustomerServiceImpl;
import lk.ijse.possystembackend.service.utill.ServiceTypes;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public synchronized static ServiceFactory getInstance(){
        return serviceFactory==null?serviceFactory=new ServiceFactory():serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes types){
        switch (types){
            case CUSTOMER_SERVICE:
                return (T) new CustomerServiceImpl();
            default:
                throw new RuntimeException("Error: Invalid service Type");
        }
    }

}
