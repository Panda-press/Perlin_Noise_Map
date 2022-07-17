import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.tree.ExpandVetoException;

import java.awt.image.BufferedImage;

import java.io.File;

public class Main {
    public static void main(String... args){
        int width = 10;
        int height = 10;
        int square_size = 100;

        BufferedImage img = new BufferedImage(width * square_size,height * square_size, BufferedImage.TYPE_INT_RGB);
        Perlin noise = new Perlin(width, height, square_size);
        for (int i = 0; i<noise.GetPixelWidth(); i++){
            for (int j = 0; j<noise.GetPixelHeight(); j++){


                int value = (int)Math.floor( 128 * (noise.GetPixel(i, j) +1) );

                img.setRGB(i, j, value);
            }
        }
        File file = new File("C:/Users/tyrre/Documents/Repositories/Perlin_Noise_Map/result.bmp");
        try{
            ImageIO.write(img, "BMP", file);
        }catch(Exception e){
            System.out.println("S");
        }
    }
}
