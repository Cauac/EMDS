package by.vsu.emdsproject.service;

import by.vsu.emdsproject.model.AbstractEntity;
import java.util.List;

public interface AbstractService<T extends AbstractEntity> {

    public void add(T entity);

    public List<T> list();

    public T read(Long id);

    public void remove(Long id);

    public void remove(T entity);
}
