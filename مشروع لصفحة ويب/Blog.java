import java.util.*;
import java.io.*;


public class Blog {
    private ArrayList<Category> categories = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Blog blog = new Blog();
        blog.askUser();
    }

    public void askUser() {

        b:
        while (true) {
            System.out.println("Welcome to our blog!");
            System.out.println("Please select one of the following options:");
            System.out.println("    1. List Category");
            System.out.println("    2. View Category");
            System.out.println("    3. Add Category");
            System.out.println("    4. Delete Category");
            System.out.println("    5. Exit");
            System.out.print("Enter Selection: ");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    listCategory();
                    break;
                case 2:
                    viewCategory();
                    break;
                case 3:
                    addCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    break b;

                default:
                    System.out.println("unknown command");
            }

        }


    }

    public void listCategory() {
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%d: %s%n", i, categories.get(i).getName());
        }

    }

    public void addCategory() {
        input.nextLine();
        System.out.print("Enter file name: ");
        String name = input.next();
        //System.out.println("Enter post content {end} to finish");
        String string ="data/"+name.trim();
        File f = new File(string);
        f.mkdir();
        Category category = new Category();
        category.setName(name);

        // Place your code here!
        try {
            categories.add(category);
            System.out.println("category saved!");
        } catch (Exception ex) {
            System.out.println("Couldn't save the category!");
        }
        System.gc();

        category.askUser();
    }
    public void viewCategory() {
        System.out.print("Enter the name file : ");
        String fileName = input.next();
        File file =new File("data/"+fileName);
        String [] fileList=file.list();
        for (String str:fileList) {
            System.out.println(str);
        }
    }
    public void deleteCategory() {
        System.out.print("Enter folder name :");
        String string = "data/" + input.next().trim();
        File f = new File(string);
        if (f.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

}
