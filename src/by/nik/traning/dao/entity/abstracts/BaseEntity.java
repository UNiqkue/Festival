package by.nik.traning.dao.entity.abstracts;

public abstract class BaseEntity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}