package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Convert {
    private BufferedImage bufferedImage;
    private final int height;
    private final int width;
    private final char white;
    private final char black;

    public Convert(File path, char white, char black) {
        try {
            this.bufferedImage = ImageIO.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.height = bufferedImage.getHeight();
        this.width = bufferedImage.getWidth();
        this.black = black;
        this.white = white;
    }

    public void drawImage() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (bufferedImage.getRGB(j, i) == -1) {
                    System.out.print(white);
                } else {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }
}
