package practice.designpatterns.decorator.window;

class VerticalScrollBarDecorator extends WindowDecorator {
    public VerticalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void drawVerticalScrollBar() {
        System.out.println("draw vertical scrollbar.");
    }

    @Override
    public void draw() {
        drawVerticalScrollBar();
        decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", including vertical scrollbars";
    }
}
