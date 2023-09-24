import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Reader {
    
    public Set<Point> Pairs = new HashSet<>();
    public int[] courses;
    public void reader(String filename) throws IOException {
        File file = new File(filename);
        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));
        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        int nb;
        String[] splited;
        //int[] courses;
        while ((st = br.readLine()) != null){
            //int nb = Integer.parseInt(st);
            splited = st.split("\\s+");
            courses = new int[splited.length];
            for(int i = 0; i < splited.length;i++){
                //nb = Integer.parseInt(splited[i]);
                courses[i] = Integer.parseInt(splited[i]);
                //System.out.println(nb);
            }
            
            for(int i = 0; i < courses.length;i++)
            {
                for (int j = i+1; j < courses.length;j++){
                    Pairs.add(new Point(courses[i],courses[j]));
                }
            }

            // Print the string
            //System.out.println("***************");
        }
    }


    public int getMax(){
        int max = courses[0];
        for(int i = 0; i < courses.length; i++)
        {
            if(courses[i] > max)
            {
                max = courses[i];
            }
        }
        return max;
    }
    

    public static void main(String[] args) throws IOException {
        /*
        Reader mt = new Reader();
        mt.reader("D:\\projects\\untitled\\src\\tre-s-92.crs");
        //System.out.println(mt.Pairs);

        // finding min, max of an array
        for(Point pt : mt.Pairs){
            System.out.println(pt.getX() + "," + pt.getY());
        }
        ////
        */
    }


    
}
