import java.util.*;
import java.io.*;

public class Post {
    private String title;
    private String content;
    public Post(File file) throws Exception{
        Scanner input = new Scanner (file);
        title = input.nextLine();
        while (input.hasNext()) {
            System.out.println(input.nextLine());
        }
        input.close();
        // Complete this section!
        // You should read the post from a file!
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public  String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
    public void save(String fileName,String s) throws Exception {
        String s0="";
        PrintWriter pw = new PrintWriter("data/"+s+"/"+fileName+".txt");
        pw.println(title);
        pw.println(content);
        pw.close();
    }
}