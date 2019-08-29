import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {

   public static void main(String arg[]) throws IOException {

       ResizeImage resize = new ResizeImage();

       int i = 0;
       int k=0;
       int max=0;

       Scanner sc = new Scanner(System.in);

       System.out.println("Enter Text : ");

       String text = sc.nextLine();

       String[] textArr = text.split("\n"); //if more than one line, should add \n end of the line

       System.out.println("Enter The Path : ");

       String url = sc.nextLine();

       System.out.println("Enter The Color Hex : ");// if you choise color write hex code of color

       Color color = Color.decode(sc.nextLine());

       while(k<textArr.length){

           if (textArr[k].length() > textArr[max].length()){

            max = k;

           }

            k++;
       }

       while (i < textArr.length) {

           BufferedImage getimage = ImageIO.read(new File(url));

           int width = getimage.getWidth();
           int height = getimage.getHeight();

           if(getimage.getWidth()!=1920 || getimage.getHeight()!=1080){

               File input = new File(url);
               BufferedImage image = ImageIO.read(input);

               BufferedImage resized = resize.resizeImageFnc(image, 1080, 1920);

               File output = new File(url);
               ImageIO.write(resized, "png", output);

           }

           BufferedImage getimage1 = ImageIO.read(new File(url));

           Graphics graphics = getimage1.getGraphics();

           graphics.setColor(color);

           int size = (getimage1.getWidth()/textArr[max].length())*2;

           graphics.setFont(new Font("TimesRoman", Font.PLAIN, ((size))*1));

           int y = ((getimage1.getHeight()/2)/textArr.length);

           graphics.drawString(textArr[i], 0,((i+1)*5)*10);

           ImageIO.write(getimage1, "png", new File(url));

           i++;

       }
       System.out.println("Process Okey");

   }

}

