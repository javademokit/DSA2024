package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeMetadata {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("C:/Users/shyyadav/Downloads/datamodel/com.nokia.oss.cm.persistence.util.MetadataProvider.IMPL_CF"))) {
            Object obj = ois.readObject();
            System.out.println(obj.getClass());
        } catch (Exception e) {
            System.out.println("hello");
            e.printStackTrace();
        }
    }
}
