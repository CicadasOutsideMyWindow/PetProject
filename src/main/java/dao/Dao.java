package dao;

import com.mongodb.BasicDBObject;

public interface Dao<T,S> {

    void create(T t, S s);
    void update(T t, BasicDBObject query, BasicDBObject updates);
    void delete(T t, S s);

}
