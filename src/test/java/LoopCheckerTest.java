import static org.junit.Assert.*;

import org.junit.Test;

public class LoopCheckerTest {

    private LoopChecker loopChecker = new LoopChecker();

    @Test
    public void oneElement(){
        try{
            ListElement listElement = new ListElement(1);
            listElement.setNext(null);

            assertFalse(loopChecker.hasLoop(listElement));
        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void twoElements(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);

        element0.setNext(element1);

        assertFalse(loopChecker.hasLoop(element0));
    }

    @Test
    public void threeElements(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);
        ListElement element2 = new ListElement(2);

        element0.setNext(element1);
        element1.setNext(element2);

        assertFalse(loopChecker.hasLoop(element0));
    }

    @Test
    public void simplestLoop(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);

        element0.setNext(element1);
        element1.setNext(element0);

        assertTrue(loopChecker.hasLoop(element0));
    }

    @Test
    public void twoleadingElementsThenShortestLoop(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);
        ListElement element2 = new ListElement(2);
        ListElement element3 = new ListElement(3);

        element0.setNext(element1);
        element1.setNext(element2);
        element2.setNext(element3);
        element3.setNext(element3);

        assertTrue(loopChecker.hasLoop(element0));
    }

    @Test
    public void oneleadingElementThenFourElementLoop(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);
        ListElement element2 = new ListElement(2);
        ListElement element3 = new ListElement(3);
        ListElement element4 = new ListElement(4);
        ListElement element5 = new ListElement(5);

        element0.setNext(element1);
        element1.setNext(element2);
        element2.setNext(element3);
        element3.setNext(element4);
        element4.setNext(element5);
        element5.setNext(element2);

        assertTrue(loopChecker.hasLoop(element0));
    }

    @Test
    public void loopOverFirstElementWithFourSteps(){
        ListElement element0 = new ListElement(0);
        ListElement element1 = new ListElement(1);
        ListElement element2 = new ListElement(2);
        ListElement element3 = new ListElement(3);

        element0.setNext(element1);
        element1.setNext(element2);
        element2.setNext(element3);
        element3.setNext(element0);

        assertTrue(loopChecker.hasLoop(element0));
    }
}