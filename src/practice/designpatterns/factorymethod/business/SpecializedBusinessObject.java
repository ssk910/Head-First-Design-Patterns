package practice.designpatterns.factorymethod.business;

public class SpecializedBusinessObject {
    protected Element createDefaultElement() {
        return new SpecializedElement();
    }
    private class SpecializedElement extends Element {
        public void f(){
            System.out.println(getClass().getName());
        }
    }
}
