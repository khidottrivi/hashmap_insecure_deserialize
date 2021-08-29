// Java program on how to Serialize HashMap in Java

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class HashMapSerialize {
    public static void main(String[] args)
    {
        HashMap<URL, String> foodType = new HashMap<>();
        try {
            URL url = new URL(null,"http://google.coms");
            // storing data in HashMap
            foodType.put(url, "Fastfood");
            Field f1 = URL.class.getDeclaredField("hashCode");
            f1.setAccessible(true);
            f1.set(url,-1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//
//        foodType.put("Cherries", "Fruit");
//        foodType.put("Fish", "Seafood");
//        foodType.put("Spinach", "Vegetables");
//        foodType.put("Chicken", "Protein-Rich");

        // try catch block
        try {
            FileOutputStream myFileOutStream
                    = new FileOutputStream(
                    "C:\\Users\\trinh\\Desktop\\HashMap_InDer\\Files\\HashMapSerializeOutput.txt");

            ObjectOutputStream myObjectOutStream
                    = new ObjectOutputStream(myFileOutStream);

            myObjectOutStream.writeObject(foodType);

            // closing FileOutputStream and
            // ObjectOutputStream
            myObjectOutStream.close();
            myFileOutStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
