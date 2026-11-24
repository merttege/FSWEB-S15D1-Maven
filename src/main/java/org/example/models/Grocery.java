package org.example.models;

import java.util.*;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while(choice != 0){
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Eklenmesini istediğiniz elemanları giriniz.");
            System.out.println("2 - Cıkarılmasını istediğiniz elemanları giriniz.");

            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String  input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String  input = scanner.nextLine();
                removeItems(input);
            }
        }
    }
    public static void addItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            item = item.trim();
            if(!checkItemIsInList(item)){
                groceryList.add(item);
            }
        }
        printSorted();
    }
    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            item = item.trim();
            groceryList.remove(item);
        }
        printSorted();
    }
    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        for(String item : groceryList){
            System.out.println(item);
        }
    }
}
