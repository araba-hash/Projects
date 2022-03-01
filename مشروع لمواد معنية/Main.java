import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner input = new Scanner(System.in);
    ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.askUser();

    }

    public void askUser() throws IOException {
        while (true) {
            System.out.println("1. Create Receipt\n" +
                    "2. Add Item\n" +
                    "3. Edit Item\n" +
                    "4. Delete Item\n" +
                    "5. Exit");
            System.out.print("Enter Selection: ");
            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    createReceipt();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    editItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("unknown command");
            }

        }
    }

    public void createReceipt() throws IOException {

        double total = 0.0;
        //Item item = new Item();
        int Qty = 0;
        int code = 0;
        String name = "";
        int qty = 0;
        double price = 0.0;
        a:
        while (true) {

            System.out.print("Enter Item Code :");
            code = input.nextInt();

            if (code == 0) {
                break a;
            }

            System.out.print("Enter Item Qty :");
            Qty = input.nextInt();
            for (Item item : items) {
                if (code == item.getCode()) {
                    item.setQTY(Qty);
                }
            }
            for (Item item : items) {
                if (code == item.getCode()) {
                    name = item.getName();
                    price = item.getPrice();
                    qty = item.getQTY();
                }
            }
//            for (int i = 0; i <items.size() ; i++) {
//                if(code==items.get(i).getCode()){
//                   code=code;
//                }
//                if (Qty==items.get(i).getQTY()){
//                    Qty=Qty;
//                }
//            }
            //items.add(item);
        }
        File file=new File("data/item.txt");
        file.delete();
        file.createNewFile();
        String s ="------------Receipt------------\n";
        String f ="ITEM\t\t\t   QTY\t\tPRICE\tTOTAl\n";

        System.out.println("------------Receipt------------");
        System.out.println("ITEM\t\t\t   QTY\t\tPRICE\tTOTAl");
        String str ="";
        StringBuffer stringBuffer=new StringBuffer();
        for (Item item : items) {
            System.out.println("Item " + item.getName() + "\t\t" + item.getQTY() + "\t\t" + item.getPrice() + "\t\t" + (item.getQTY() * item.getPrice()));
            total += (item.getQTY() * item.getPrice());
            String result="Item " + item.getName() + "\t\t" + item.getQTY() + "\t\t" + item.getPrice() + "\t\t" + (item.getQTY() * item.getPrice()+"\n");
            stringBuffer.append(result);
        }

        PrintWriter printWriter=new PrintWriter("data/item.txt");
        printWriter.write(s);
        printWriter.write(f);
        printWriter.write(String.valueOf(stringBuffer));
        System.out.println("-----------------\n");
        System.out.println("TOTAL : " + total+"\n");
        printWriter.write("-----------------\n");
        printWriter.write("TOTAL : " + total+"\n");
        printWriter.close();
    }


    public void addItem() {
        Item item = new Item();
        System.out.print("Enter Item code : ");
        int code = input.nextInt();
                input.nextLine();
                System.out.print("Enter Item Name : ");
                String itemName = input.nextLine();
                System.out.print("Enter price :");
                double price = input.nextDouble();
                item.setCode(code);
                item.setQTY(0);
                item.setName(itemName);
                item.setPrice(price);
                items.add(item);
                System.out.println("Item saved !");





    }

    public void editItem() {
        System.out.print("Enter Item code : ");
        int code = input.nextInt();
        for (int i = 0; i < items.size(); i++) {
            int s = items.get(i).getCode();
            input.nextLine();
            if (code == s) {
                System.out.print("Enter Item New Name : ");
                String itemName = input.nextLine();
                if (itemName.equals(" ")) {

                } else {
                    items.get(i).setName(itemName);

                }
                System.out.print("Enter Item New Price :");
                double price = input.nextDouble();
                items.get(i).setPrice(price);
            }
        }
        System.out.println("Item saved !");
    }

    public void deleteItem() {
        System.out.print("Enter Item code : ");
        int code = input.nextInt();
        for (int i = 0; i < items.size(); i++) {
            int s = items.get(i).getCode();
            if (code == s) {
                items.remove(i);
                System.out.println("Item delete !");
            }
        }
    }
}
