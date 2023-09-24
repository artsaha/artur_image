import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.PlugInFilter;

public class ShiftVertical implements PlugInFilter {

    public int setup(String args, ImagePlus im)
    {
        return DOES_RGB;
    }

    public void run(ImageProcessor inputIP) {
        // Get the current active image
        ImagePlus imp = IJ.getImage();
        // Get the image processor
        ImageProcessor ip = imp.getProcessor();
        
        // Get the width and height of the image
        int width = ip.getWidth();
        int height = ip.getHeight();

        // Calculate the midpoint column
        int midCol = width / 2;

        // Swap the upper and lower parts of the image using a for loop
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < midCol; x++) {
                // Swap pixel values at (x, y) and (x, height - 1 - y)
                int temp = ip.getPixel(x, y);
                ip.putPixel(x, y, ip.getPixel(x+midCol, y));
                ip.putPixel(x + midCol, y , temp);
            }
        }
        
        // Update the image window
        imp.updateAndDraw();
    }
    
}
