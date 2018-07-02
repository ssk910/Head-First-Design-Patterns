package practice.designpatterns.decorator.window;

class HorizontalScrollBarDecorator extends WindowDecorator {
    public HorizontalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void drawHorizontalScrollBar() {
        System.out.println("draw horizontal scrollbar.");
    }

    @Override
    public void draw() {
        drawHorizontalScrollBar();
        decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including horizontal scrollbars";
    }
}
