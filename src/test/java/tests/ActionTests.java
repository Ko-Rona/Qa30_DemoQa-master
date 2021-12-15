package tests;

import org.testng.annotations.Test;

public class ActionTests extends TestBase{

    @Test
    public void actionTest(){
        app.action().selectInteraction();
        app.action().selectDroppable();
        app.action().droppebleTest();

    }

    @Test
    public void actionTest2(){
        app.action().selectInteraction();
        app.action().selectDroppable();
        app.action().droppebleTest2();

    }
}
