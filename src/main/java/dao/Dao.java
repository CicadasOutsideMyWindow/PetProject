package dao;

import org.bson.Document;

public interface Dao<S> {

    Document create(S s);
    Document retrieve(String id);
    Document update(S s);
    Document delete(String id);

}
