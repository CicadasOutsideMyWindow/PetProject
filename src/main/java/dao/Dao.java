package dao;

import org.bson.Document;

public interface Dao<S> {

    S create(S s);
    S retrieve(String id);
    S update(S s) throws Exception;
    S delete(String id) throws Exception;

}
