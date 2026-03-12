import java.nio.*;
import java.util.*;
public class BufferSlicing {
    public static void main(String[] args) {
        int capacity = 5;
        try {
            ByteBuffer bb1 = ByteBuffer.allocate(capacity);
            bb1.put((byte) 10);
            bb1.put((byte) 20);
            System.out.println("Original ByteBuffer: " + Arrays.toString(bb1.array()));
            // Print ByteBuffer position
            System.out.println("\nposition: " + bb1.position());
            // Print ByteBuffer capacity
            System.out.println("\ncapacity: " + bb1.capacity());
            // Creating a shared subsequence buffer using slice()
            ByteBuffer bb2 = bb1.slice();
            // Print the shared subsequence buffer
            System.out.println("\nshared subsequence ByteBuffer: " + Arrays.toString(bb2.array()));
            // Print sliced buffer position
            System.out.println("\nposition: " + bb2.position());
            // Print sliced buffer capacity
            System.out.println("\ncapacity: " + bb2.capacity());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        } catch (ReadOnlyBufferException e) {
            System.out.println("ReadOnlyBufferException caught");
        }
    }
}
