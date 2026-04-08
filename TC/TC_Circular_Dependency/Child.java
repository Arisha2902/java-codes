package TC.TC_Circular_Dependency;
public class Child {
    private Parent parent;
    public Child(Parent p) { this.parent = p; }
    public void printParentName() { 
        System.out.println(parent.getName()); 
    }
}