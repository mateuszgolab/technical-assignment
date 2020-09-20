package co.uk.gumtree.backend.service.dao;

import co.uk.gumtree.backend.model.Gender;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();

    List<T> getByGender(Gender gender);

    List<T> getByFirstName(String firstName);

}
