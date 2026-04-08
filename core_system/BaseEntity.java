package core_system;

public abstract class BaseEntity {
    protected String id;
    protected String name;

    public BaseEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getEntityType();
    public abstract boolean isValid();
}
