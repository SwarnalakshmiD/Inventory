import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Product {
    public int productId;
    public String productName;
    public float productPrice;
    public int productQuantity;

    Product(int pId,String pName,float pPrice,int pQnty)
    {
        productId=pId;
        productName=pName;
        productPrice=pPrice;
        productQuantity=pQnty;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Inventory inv = new Inventory();
        inv.getProduct();


        while (true) {
            System.out.println("ENTER 0 TO ADD");
            System.out.println("ENTER 1 TO PURCHASE");
            System.out.println("ENTER 2 TO SEE DETAILS");
            System.out.println("ENTER 3 TO GENERATE REPORTS");
            System.out.println("ENTER 4 TO GENERATE REPORTS");


            System.out.println("enter the choice:");
            int n = sc.nextInt();
            switch (n) {
                case 0:
                    System.out.println("enter the product id to add");
                    inv.addProduct();
                    break;
                case 1:
                    System.out.println("enter the product id and quantity to purchase");

                    inv.updateInventory();
                    break;
                case 2:
                    System.out.println("enter the product id to see details");
                    inv.showDetails(sc.nextInt());
                    break;
                case 3:
                    System.out.println("enter 0 to view report of all products and 1 for particular product");
                    int opt=sc.nextInt();
                    inv.generateReport(opt);
                    break;

                case 4:

                    return;

            }


        }
    }
    }

