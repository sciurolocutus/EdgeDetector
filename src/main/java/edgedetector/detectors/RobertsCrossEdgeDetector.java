/**************************************************************************
 * @author Jason Altschuler
 *
 * @tags edge detection, image analysis, computer vision, AI, machine learning
 *
 * PURPOSE: Edge detector
 *
 * ALGORITHM: RobertsCross edge detector algorithm
 *
 * For full documentation, see the README
  ************************************************************************/

package edgedetector.detectors;

import edgedetector.util.Grayscale;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class RobertsCrossEdgeDetector extends GaussianEdgeDetector {
   
   /*********************************************************************
    * Convolution kernels
    *********************************************************************/
   private final static double[][] X_kernel = {{1, 0},
                                               {0, -1}};

   private final static double[][] Y_kernel = {{0, -1},
                                               {1, 0}};

   /*********************************************************************
    * Implemented abstract methods
    *********************************************************************/

   /**
    * @Override
    * {{1, 0}, {0, -1}}
    */
   public double[][] getXkernel() {
      return RobertsCrossEdgeDetector.X_kernel;
   }
   
   /**
    * @Override
    * {{0, -1}, {1, 0}}
    */
   public double[][] getYkernel() {
      return RobertsCrossEdgeDetector.Y_kernel;
   }

   
   /*********************************************************************
    * Constructor 
    **********************************************************************/
   
   /**
    * All work is done in constructor.
    * @param filePath path to image
    */
   public RobertsCrossEdgeDetector(String filePath) {
      // read image and get pixels
      BufferedImage originalImage;
      try {
         originalImage = ImageIO.read(new File(filePath));
         findEdges(Grayscale.imgToGrayPixels(originalImage), false);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /**
    * All work is done in constructor.
    * <P> Uses L2 norm by default.
    * @param image
    */
   public RobertsCrossEdgeDetector(int[][] image) {
      findEdges(image, false);
   }
   
   /**
    * All work is done in constructor. 
    * <P> Gives option to use L1 or L2 norm.
    */
   public RobertsCrossEdgeDetector(int[][] image, boolean L1norm) {
      findEdges(image, L1norm);
   }

}
