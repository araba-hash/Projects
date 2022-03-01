import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Category {
     private static String name;

    public   String getName() {
        return name;
    }

    public Category(String name) {
        this.name=name;
    }
    public Category() {
    }
    public void setName(String name) {
        this.name = name;
    }
    Scanner input =new Scanner(System.in);

    private ArrayList<Post> posts = new ArrayList<Post>();
    public void askUser () {
        try {
            updatePosts();
        } catch (Exception ex) {
            System.out.println("Can't find data folder!!");
            System.exit(1);
        }
        System.out.println("Welcome to our blog!");
        System.out.println("Please select one of the following options:");
        System.out.println("    1. List Posts");
        System.out.println("    2. View Post");
        System.out.println("    3. Add Post");
        System.out.println("    4. Delete Post");
        System.out.println("    5. Exit");
        Scanner input = new Scanner(System.in);
        b: while (true) {
            System.out.print("Enter Selection: ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    listPosts();
                    break;
                case 2:
                    System.out.print("Enter the post index: ");
                    int index = input.nextInt();
                    viewPost(index);
                    break;
                case 3:
                    addPost();
                    break;
                case 4:
                    //System.gc();
                    deletePosts();
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    break  b ;

                default:
                    System.out.println("unknown command");
            }

        }


    }
    public  void deletePosts() {
        Scanner input =new Scanner(System.in);
//        System.out.print("Enter file name :");
        String s=getName();
        String string ="data/"+s+"/"+input.next().trim();
        File f = new File(string);
        if (f.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }

        //  case 4:
        //                    deletePosts();
        //                    break;
//        //System.out.println("Enter file name ");
//        File f = new File("data/");
//        File[] list = f.listFiles();
//        for(File pf : list) {
//            System.out.println(pf.delete());
//
//       }
        //


    }
    public void updatePosts () throws Exception {
        String s=getName();
        File f = new File("data/"+s+"/");
        File[] list = f.listFiles();

        // Place your code here!
        for(File pf : list) {
            posts.add(new Post(pf));
        }
    }
    public void listPosts (){
        for(int i=0;i<posts.size();i++) {
            System.out.printf ("%d: %s%n", i, posts.get(i).getTitle());
        }
    }
    public void viewPost (int index) {
        System.out.println(posts.get(index).getContent());
        System.out.println(posts.get(index).getTitle());

    }
    public void addPost () {
        System.gc();
        System.out.print("Enter post title: ");
        String title = input.nextLine();
        System.out.println("Enter post content {end} to finish");
        String content = "";
        while (true){
            String line=input.nextLine().trim();
            if (line.equals("end")){
                break;
            }
            content+=line +"\n";
        }
        Post post = new Post(title, content);
        // Place your code here!
        try {
            post.save(posts.size() + "",getName());
            posts.add(post);
            System.out.println("Post saved!");
        } catch (Exception ex) {
            System.out.println("Couldn't save the post!");
        }
}
}
