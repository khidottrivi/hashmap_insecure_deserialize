import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Java_Deserialize {
    public static void main(final String[] args) throws Exception{
        RandomAccessFile f = new RandomAccessFile("C:\\Users\\trinh\\Desktop\\Bytes_Array.txt", "r");
        byte[] b = new byte[(int)f.length()];
        f.readFully(b);
        final ByteArrayInputStream in = new ByteArrayInputStream(b);
        final ObjectInputStream objIn = new ObjectInputStream(in);
        System.out.println(objIn.readObject());
    }
}
