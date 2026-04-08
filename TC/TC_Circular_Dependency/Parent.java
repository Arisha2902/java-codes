package TC.TC_Circular_Dependency;
public class Parent {
    private Child child;
    public void setChild(Child c) { this.child = c; }
    public String getName() { return "Root"; }
}