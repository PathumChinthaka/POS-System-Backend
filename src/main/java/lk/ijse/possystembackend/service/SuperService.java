package lk.ijse.possystembackend.service;

import lk.ijse.possystembackend.dto.SuperDTO;

public interface SuperService < T extends SuperDTO>{

    boolean saveData(T dto);

    boolean updateData(T dto);

    T showData(T dto);

    boolean deleteData(T dto);

}
