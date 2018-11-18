package dao;

import com.mongodb.BasicDBObject;

public interface Dao<T,S> {

    void create(S s);
    void update(BasicDBObject query, BasicDBObject updates);
    void delete(S s);

}
