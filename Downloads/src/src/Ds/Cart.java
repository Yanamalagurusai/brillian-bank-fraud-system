package Ds;

import java.util.Scanner;

public class Cart {

    static class Product {
        int productId;
        String productName;
        double price;
        int quantity;

        Product(int id, String name, double price, int qty) {
            this.productId = id;
            this.productName = name;
            this.price = price;
            this.quantity = qty;
        }
    }

    static class Node {

        Product product;
        Node next;

        Node(Product product) {
            this.product = product;
            this.next = null;
        }
    }

    Node head;

    void addProduct(Product product) {

        Node newNode = new Node(product);

        if (head == null) {
            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Product Added Successfully");
    }

    void removeProduct(int id) {

        if (head == null) {
            System.out.println("Cart is Empty");
            return;
        }

        if (head.product.productId == id) {
            head = head.next;
            System.out.println("Product Removed Successfully");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               temp.next.product.productId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Product Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Product Removed Successfully");
        }
    }

    void updateQuantity(int id, int qty) {

        Node temp = head;

        while (temp != null) {

            if (temp.product.productId == id) {

                temp.product.quantity = qty;

                System.out.println("Quantity Updated Successfully");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Product Not Found");
    }

    void displayCart() {

        if (head == null) {
            System.out.println("Cart is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {

            System.out.println(
                "ID: " + temp.product.productId +
                ", Name: " + temp.product.productName +
                ", Price: " + temp.product.price +
                ", Quantity: " + temp.product.quantity
            );

            temp = temp.next;
        }
    }

    void calculateTotal() {

        double total = 0;

        Node temp = head;

        while (temp != null) {

            total += temp.product.price *
                     temp.product.quantity;

            temp = temp.next;
        }

        System.out.println("Total Bill Amount: " + total);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();

        int choice;

        do {

            System.out.println("\n1.Add Product");
            System.out.println("2.Remove Product");
            System.out.println("3.Update Quantity");
            System.out.println("4.Display Cart");
            System.out.println("5.Calculate Total");
            System.out.println("6.Exit");

            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter Product ID:");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Product Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Product Price:");
                    double price = sc.nextDouble();

                    System.out.println("Enter Quantity:");
                    int qty = sc.nextInt();

                    Product p = new Product(id, name, price, qty);

                    cart.addProduct(p);

                    break;

                case 2:

                    System.out.println("Enter Product ID to Remove:");
                    int removeId = sc.nextInt();

                    cart.removeProduct(removeId);

                    break;

                case 3:

                    System.out.println("Enter Product ID:");
                    int updateId = sc.nextInt();

                    System.out.println("Enter New Quantity:");
                    int newQty = sc.nextInt();

                    cart.updateQuantity(updateId, newQty);

                    break;

                case 4:

                    cart.displayCart();

                    break;

                case 5:

                    cart.calculateTotal();

                    break;

                case 6:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}