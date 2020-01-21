package edgedetector.util;

import java.awt.image.BufferedImage;

public class Threshold {

  private static final int WHITE_RGB = 16777215; // 0x00FFFFFF
  private static final int BLACK_RGB = 0;

  public static BufferedImage applyThresholdReversed(boolean[][] edges) {
    BufferedImage image = new BufferedImage(edges.length, edges[0].length, BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i<edges.length ; i++) {
      for (int j=0; j<edges[i].length; j++) {
        image.setRGB(i, j, (edges[i][j] ? BLACK_RGB : WHITE_RGB));
      }
    }

    return image;
  }

  public static int calcThresholdEdges(int[][] convolvedImage) {
    int sum = 0;
    int nElements = 0;
    for (int i = 0; i < convolvedImage.length; i++) {
      for (int j = 0; j < convolvedImage[i].length; j++) {
        sum += convolvedImage[i][j];
        nElements++;
      }
    }

    return sum / nElements;
  }
}
