package HuffmanImplementaion;
import FileOp.*;
public class implementationClass implements encodeDecode{

    huffmanInterface hf= new EncodeDecodeImplementation();
    FileOperations fo= new FileOperations();
    @Override
    public void encode() {
        String msg=fo.readFile();
        //String msg="hello";
        hf.generate(msg);   
        StringBuilder sb1= hf.encodeString(msg);
        // System.out.println(sb1);
        fo.write(sb1);
    }

    @Override
    public void decode() {
        String msg=fo.readFile();
        StringBuilder sb1= hf.decodeString(msg);
        // System.out.println(sb1);
        fo.write(sb1);
    }
    
}
