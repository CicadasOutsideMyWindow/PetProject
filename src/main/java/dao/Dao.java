package dao;

public interface Dao<S> {

    S create(S s);
    S retrieve(String id);
    S update(String id, S s) throws Exception;
    S delete(String id) throws Exception;

}
