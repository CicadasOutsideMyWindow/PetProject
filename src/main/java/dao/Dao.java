package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public interface Dao<T,S> {

    void create(S s);
    DBObject retrieve(String id);
    void update(BasicDBObject query, BasicDBObject updates);
    void delete(String id);

}
