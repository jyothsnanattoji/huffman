package Run;
//import FileOp.*;
import HuffmanImplementaion.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //Huffman Implementaion
        encodeDecode ed= new implementationClass();
        long startTime = System.currentTimeMillis();
        ed.encode();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Encode time in milliseconds: " + elapsedTime);

        startTime = System.currentTimeMillis();
        ed.decode();
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Decode time in milliseconds: " + elapsedTime);
    }
    
}
