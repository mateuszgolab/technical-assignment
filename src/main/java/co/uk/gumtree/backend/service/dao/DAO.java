package co.uk.gumtree.backend.service.dao;

import java.util.List;

public interface DAO<T> {

    public List<T> getAll();

}
