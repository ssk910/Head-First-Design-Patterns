package practice.designpatterns.factorymethod.business;

public class BusinessObject {
    public void doSomething() {
        Element e = createDefaultElement();
        e.f();
    }
    protected Element createDefaultElement() {
        return new Element();
    }
}
