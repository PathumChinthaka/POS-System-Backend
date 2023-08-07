package lk.ijse.possystembackend.dao;

import lk.ijse.possystembackend.entity.SuperEntity;
import org.hibernate.Session;

public interface CrudDAO <T extends SuperEntity> extends SuperDAO {
    boolean saveData(T entity, Session session);
    boolean updateData(T entity, Session session);
    T showData(T entity, Session session);
    boolean deleteData(T entity, Session session);

}
