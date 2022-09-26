package edu.school21.spring;

public class PrinterWithPrefixImpl implements Printer {
    private final Renderer render;
    private final String prefix;

    public PrinterWithPrefixImpl(Renderer render) {
        this.render = render;
        this.prefix = "prefix";
    }

    @Override
    public void print(String message) {
        render.print(prefix + " " + message);
    }
}
