package app.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu implements Menu {
    private List<MenuItem> itemList;

    public ConsoleMenu() {
        itemList = new ArrayList<>();
    }

    @Override
    public void add(MenuItem menuItem) {
        itemList.add(menuItem);
    }

    @Override
    public void print() {
        System.out.println("\tВыберите пункт меню:");
        int i = 1;
        for (MenuItem menuItem : itemList) {
            System.out.println(i + ". " + menuItem.getDescription());
            i++;
        }
        System.out.println();
    }
    
    @Override
    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            print();
            int choice = scanner.nextInt();
            MenuItem menuItem = itemList.get(choice - 1);
            menuItem.toDo();
            if (choice == itemList.size()) {
                exit = true;
            }
        }
        scanner.close();
    }
}