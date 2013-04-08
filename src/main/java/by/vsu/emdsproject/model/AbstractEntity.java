package by.vsu.emdsproject.model;

import java.io.Serializable;

// todo: spring form validation
public interface AbstractEntity extends Serializable {

    public Long getId();

    public void setId(Long id);
}
