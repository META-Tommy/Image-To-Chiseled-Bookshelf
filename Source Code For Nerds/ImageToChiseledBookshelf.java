//By: @META_Tommy
//10/17/2022
package imagetochiseledbookshelf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageToChiseledBookshelf {

    public static void main(String[] args) throws IOException {
        
        File file = new File(args[0]);
        FileWriter file2 = new FileWriter (args[1]+"\\Chiseled_Bookshelf_Data.txt");
        BufferedImage picture = ImageIO.read(file);
        int[] rgb = new int[3];
        int current;
        int width = picture.getWidth();
        int height = picture.getHeight();
        
        //get size for bookshelf
        file2.write((width/3)+"\n");
        file2.write((height/2)+"\n");
        
        //a bookshelf is 3 books long and 2 books high
        for(int x = 0; x < width; x+=3){
            for(int y = 0; y < height; y+=2){
                //the resource pack splits bookshelfs up into a top and bottom row
                
                //we create a number in base 7 with 3 digits, where each digit represents
                //the color of a book in the current row
                
                //top row
                current = 0;
                picture.getData().getPixel(x, y, rgb);
                current += getColor(rgb)*49;
                picture.getData().getPixel(x+1, y, rgb);
                current += getColor(rgb)*7;
                picture.getData().getPixel(x+2, y, rgb);
                current += getColor(rgb);
                file2.write(numToRed(current));
                
                //bottom row
                current = 343; //the value where bottom row models start in the resource pack
                picture.getData().getPixel(x, y+1, rgb);
                current += getColor(rgb)*49;
                picture.getData().getPixel(x+1, y+1, rgb);
                current += getColor(rgb)*7;
                picture.getData().getPixel(x+2, y+1, rgb);
                current += getColor(rgb);
                file2.write(numToRed(current));
            }
        }
        
        file2.close();
    }
    
    //finds color thats closest to rgb in the array values
    //values corresponds to the colors of books
    static int getColor(int[] rgb){
        final int[][] values = 
            {{46,32,17}, //blank
            {136,48,71},  //magenta
            {119,72,53},  //orange
            {71,102,37},//green
            {18,96,94},//cyan
            {27,59,110},//blue
            {81,33,110}};//purple
        double lowestDistance = Math.sqrt(Math.pow(values[0][0]-rgb[0],2)+Math.pow(values[0][1]-rgb[1],2)+Math.pow(values[0][2]-rgb[2],2));
        double currentDistance;
        int current = 0;
        for(int i = 1; i < 7; i++){
            currentDistance = Math.sqrt(Math.pow(values[i][0]-rgb[0],2)+Math.pow(values[i][1]-rgb[1],2)+Math.pow(values[i][2]-rgb[2],2));
            if(currentDistance < lowestDistance){
                lowestDistance = currentDistance;
                current = i;
            }
        }
        return current;
    }
    
    //converts a number to redstone wire blockstates
    //these block states display as colored books when using a resource pack
    //x represents a number in base 7
    //where the 3 digits represent the colors of each book in a row
    static String numToRed(int x){
        final String[] shape = {"none","side","up"};
        String result = "[power="+(x%16);
        x/=16;
        result += ",east="+shape[x%3];
        x/=3;
        result += ",west="+shape[x%3];
        x/=3;
        result += ",north="+shape[x%3];
        x/=3;
        result += ",south="+shape[x%3]+"]\n";
        return result;
    }
}
