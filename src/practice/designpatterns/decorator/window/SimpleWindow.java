package practice.designpatterns.decorator.window;

class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("draw window.");
    }

    @Override
    public String getDescription() {
        return "simple window";
    }
}
