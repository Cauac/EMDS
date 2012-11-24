package by.vsu.emdsproject.model;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

    protected Long id;
    
    public abstract Long getId();

    public void setId(Long id) {
        this.id = id;
    }
}
