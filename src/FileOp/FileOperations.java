package FileOp;
import java.io.*;
import java.util.Scanner;

public class FileOperations implements fileRead{
    Scanner sc= new Scanner(System.in);

    public String readFile() {
        System.out.println("Enter the name of the File to be read: ");
        String name=sc.nextLine();
        String fileName= "C:\\Users\\Jyo\\Desktop\\Huffman Encoding\\compresssion\\"+name;
        StringBuilder sb= new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) 
        {
            String str;
            while ((str = buffer.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    return sb.toString();
}

public void write(StringBuilder sb) {
    System.out.println("Enter the name of the OutputFile: ");
    String name=sc.nextLine();
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(name)))) {
            writer.write(sb.toString());
            sb.setLength(sb.length()-1);
    } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }
}
    
}
