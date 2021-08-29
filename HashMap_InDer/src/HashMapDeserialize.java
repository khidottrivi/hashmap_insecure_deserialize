// Deserializing HashMap in Java

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDeserialize {
    public static void main(String[] args)
    {
//        HashMap<String, String> newHashMap = null;
        HashMap newHashMap = new HashMap();

        try {
            FileInputStream fileInput = new FileInputStream(
                    "C:\\Users\\trinh\\Desktop\\HashMap_InDer\\Files\\HashMapSerializeOutput.txt");

            ObjectInputStream objectInput
                    = new ObjectInputStream(fileInput);

            newHashMap = (HashMap)objectInput.readObject();

            objectInput.close();
            fileInput.close();
        }

        catch (IOException obj1) {
            obj1.printStackTrace();
            return;
        }

        catch (ClassNotFoundException obj2) {
            System.out.println("Class not found");
            obj2.printStackTrace();
            return;
        }

        System.out.println("Deserializing  HashMap..");

        // Displaying content in "newHashMap.txt" using
        // Iterator
        Set set = newHashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();

            System.out.print("key : " + entry.getKey()
                    + " & Value : ");
            System.out.println(entry.getValue());
        }
    }
}
