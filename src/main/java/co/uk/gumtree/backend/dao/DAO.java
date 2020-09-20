package co.uk.gumtree.backend.dao;

import java.util.List;

public interface DAO<T> {
    
    List<T> getAll();
    
}