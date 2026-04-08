package TC.TC_Circular_Dependency;
public class NodeManager {
    public void link() {
        Parent p = new Parent();
        Child c = new Child(p);
        p.setChild(c);
    }
}