package HuffmanImplementaion;
import FileOp.*;
public class implementationClass implements encodeDecode{

    huffmanInterface hf= new EncodeDecodeImplementation();
    FileOperations fo= new FileOperations();
    @Override
    public void encode() {
        String msg=fo.readFile();
        hf.generate(msg);   
        StringBuilder sb=new StringBuilder();
        sb=hf.encodeString(msg);
        fo.writeEncoded(sb);
    }

    @Override
    public void decode() {
        StringBuilder sb=new StringBuilder();
        sb=fo.BinaryFilesToString();
        //System.out.println(sb);
        hf.decodeString(sb.toString());
    } 
}
