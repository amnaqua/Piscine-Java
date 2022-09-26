package edu.school21.spring;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private final Renderer render;
    private final LocalDateTime localDateTime;

    public PrinterWithDateTimeImpl(Renderer render) {
        this.render = render;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public void print(String message) {
        render.print(message + " " + localDateTime);
    }
}
