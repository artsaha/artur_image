import ij.*;
import ij.gui.*;
import ij.plugin.PlugIn;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import ij.process.ImageProcessor; // Added import for ImageProcessor

public class StudentTable implements PlugIn {

    Reader mt;

    public void init() throws IOException
    {
        mt = new Reader();
        // Please replace with the file location you need
        mt.reader("D:\\projects\\untitled\\src\\tre-s-92.crs");
        //System.out.println(mt.Pairs);
        // finding  max of an array my next step
        for(Point pt : mt.Pairs){
            System.out.println(pt.getX() + "," + pt.getY());
        }  

    }


    public void run(String arg)  {

        try{
            init();
        }catch(IOException e){
            e.printStackTrace();
        }
    
        int max = mt.getMax();

        int rows = max; // Number of rows
        int cols = max; // Number of columns
        int squareSize = 1; // Size of each square in pixels

        // Calculate the image dimensions
        int width = cols * squareSize;
        int height = rows * squareSize;

        // Create a new img
        ImagePlus imp = IJ.createImage("Grid Image", "8-bit black", width, height, 1);

        // Get the image's processor
        ImageProcessor ip = imp.getProcessor();
        
        ip.setValue(255);
        ip.fill();

        for(Point pt : mt.Pairs)
        {
            ip.putPixel((int)pt.getX(), (int)pt.getY(), 0);
            ip.putPixel((int)pt.getY(), (int)pt.getX(),0);
        }  
    
        // Show gen img
        imp.show();

    }


}
