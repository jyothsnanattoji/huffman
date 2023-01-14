    package FileOp;
    import java.io.*;
    import java.nio.file.Files;
    import java.nio.file.Paths;
    import java.util.Scanner;

    public class FileOperations implements fileRead,fileWrite{
        Scanner sc= new Scanner(System.in);
        public String readFile() {
            String fileName= "pg100.txt";
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

    public void writeEncoded(StringBuilder sb) {
        try (FileOutputStream fos = new FileOutputStream("compressed.bin")) {
            byte[] bytes = new byte[(int) Math.ceil(sb.length() / 8.0)];
            for (int i = 0;i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    bytes[i / 8] |= (1 << (7 - (i % 8)));
                }
            }
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder BinaryFilesToString() 
    {
        byte[] input;
    try {
        input = Files.readAllBytes(Paths.get("compressed.bin"));
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    StringBuilder sb = new StringBuilder();
    for (byte b : input) {
        for (int i = 7; i >= 0; i--) {
            sb.append((b & (1 << i)) == 0 ? '0' : '1');
        }
    }
        return sb;
    }

    public void writeDecoded(StringBuilder text)
    {
        try (PrintWriter pw = new PrintWriter("decompressed.txt")) {
            pw.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
