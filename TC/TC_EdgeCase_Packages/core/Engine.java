package TC.TC_EdgeCase_Packages.core;
public class Engine {
    private Config cfg = new Config();
    public void boot() { System.out.println("Target: " + cfg.getUrl()); }
}