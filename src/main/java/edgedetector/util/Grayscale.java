package edgedetector.util;

import java.awt.image.BufferedImage;

public class Grayscale {

  private static int pixelToGray(int pixel) {
    int a = (pixel >> 24) & 0xff;
    int r = (pixel >> 16) & 0xff;
    int g = (pixel >> 8) & 0xff;
    int b = pixel & 0xff;

    int avg = (r + g + b) / 3;
    return (a << 24 | avg << 16 | avg << 8 | avg);
  }

  public static void greyscaleInPlace(BufferedImage image) {
    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        int pixel = image.getRGB(x, y);
        image.setRGB(x, y, pixelToGray(pixel));
      }
    }
  }

  public static int[][] imgToGrayPixels(BufferedImage image) {
    int[][] pixels = new int[image.getWidth()][image.getHeight()];

    for (int i=0; i<pixels.length; i++) {
      for (int j=0; j<pixels.length; j++) {
        pixels[i][j] = pixelToGray(image.getRGB(i, j));
      }
    }

    return pixels;
  }

  /**
   * Extract the pixel images into a two-dimensional array of ints, pixel values.
   * @param image an existing image
   * @return a two-dimensional array of its pixels as ints
   */
  public static int[][] imgToPixels(BufferedImage image) {
    int[][] pixels = new int[image.getWidth()][image.getHeight()];

    for (int i=0; i<pixels.length; i++) {
      for (int j=0; j<pixels.length; j++) {
        pixels[i][j] = image.getRGB(i, j);
      }
    }

    return pixels;
  }
}