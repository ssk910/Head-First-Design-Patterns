package practice.designpatterns.factorymethod.business;

public class TestPattern {
    public static void main(String[] args) {
        BusinessObject businessObject = new BusinessObject();
        businessObject.doSomething();

        SpecializedBusinessObject specializedBusinessObject = new SpecializedBusinessObject();
        specializedBusinessObject.createDefaultElement().f();
    }
}