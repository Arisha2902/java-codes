package TC.TC_EdgeCase_Packages.api;

import TC.TC_EdgeCase_Packages.core.Engine;

public class RestService {
    private Engine engine = new Engine();

    public Response execute() {
        engine.boot();
        return new Response();
    }
}