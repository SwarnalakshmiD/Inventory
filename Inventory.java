import java.io.*;
import java.util.*;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


public class Inventory {
    List<Product> arr = new ArrayList<Product>();

    public void getProduct(){

        try {
            Scanner scanner = new Scanner(new File("/Users/swarnalakshmi/IdeaProjects/inventory/src/main/java/Product.txt"));

            while (scanner.hasNextLine()) {
                String[] prodDetails = scanner.nextLine().split(",");
                int id=parseInt(prodDetails[0]);
                String name=prodDetails[1];
                float price=parseFloat(prodDetails[2]);
                int quantity=parseInt(prodDetails[3]);
                Product obj = new Product(id, name, price, quantity);
                arr.add(obj);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
    public void addProduct() {
        String appendDetails=null;
        Scanner sc=new Scanner(System.in);

            int id = sc.nextInt();
            String name = sc.next();
            float price = sc.nextFloat();
            int qty = sc.nextInt();
            if(price<0|| qty<0)
            {
                 System.out.println("Enter only positive values");
                return;
            }
                for (Product p : arr) {
                    if (p.productId == id) {
                        System.out.println("Product id already mapped");
                        return;
                    }
                }
                Product obj = new Product(id, name, price, qty);
                arr.add(obj);
                appendDetails=obj.productId+","+obj.productName+","+obj.productPrice+","+obj.productQuantity;





            try {
                Writer fileWriter = new FileWriter("/Users/swarnalakshmi/IdeaProjects/inventory/src/main/java/Product.txt", true);
                fileWriter.append(appendDetails);
                fileWriter.close();
            }
            catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        }

    public void updateInventory()
    {
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        int qnty=sc.nextInt();
        for (Product p : arr) {
            if (p.productId == id) {
                if (p.productQuantity >= qnty) {

                    p.productQuantity = p.productQuantity - qnty;
                } else {
                    System.out.println(" available quantity " + p.productQuantity);

                }
            }
        }
        System.out.println(" product doesnt exist");

    }

    public void showDetails(int id)
    {
        for (Product p : arr) {
            if (p.productId == id) {
                System.out.println("product id " + p.productId);
                System.out.println("product name " + p.productName);
                System.out.println("product quantity " + p.productQuantity);
                System.out.println("product price " + p.productPrice);

            }
        }

    }
    public void generateReport(int opt) {
        float total = 0;
        double totValue = 0;
        if (opt == 0) {
            for (Product p : arr) {
                total = p.productQuantity * p.productPrice;

                totValue += total;
            }
            System.out.println("the total value is: " + totValue);
        } else {
            System.out.println("enter the id to generate report");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (Product p : arr) {
                if (p.productId == id) {
                    total = p.productQuantity * p.productPrice;

                    totValue += total;
                    System.out.println("the total value is: " + totValue);
                }
            }


            }


        }







}
