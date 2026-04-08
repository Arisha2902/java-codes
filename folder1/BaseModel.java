// File 1: BaseModel.java - Base class for all models
package folder1;

public abstract class BaseModel {
    protected String id;
    protected String createdAt;
    
    public BaseModel(String id) {
        this.id = id;
        this.createdAt = System.currentTimeMillis() + "";
    }
    
    public String getId() {
        return id;
    }
    
    public abstract String getType();
    
    public abstract boolean validate();
}
