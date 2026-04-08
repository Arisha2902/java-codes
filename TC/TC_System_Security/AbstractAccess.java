
public abstract class AbstractAccess implements Permission {
    protected int level;
    public AbstractAccess(int level) { this.level = level; }
}