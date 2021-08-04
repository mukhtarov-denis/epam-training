package app;

import java.util.Scanner;

import app.comparator.FreshnessComparator;
import app.console.ConsoleMenu;
import app.console.Menu;
import app.console.MenuItem;
import app.entity.bouquet.Bouquet;
import app.factory.BouquetFactory;
import app.filter.Filter;
import app.filter.impl.RangeLength;
import app.operation.impl.Manager;

public class FlowerApp {
    public static void main(String[] args) {
        Manager manager = BouquetFactory.getInstance();
        Bouquet bouquet = manager.buildBouquet();
        Menu menu = new ConsoleMenu();
        menu.add(new MenuItem("Показать состав букета") {   
            @Override
            public void toDo() {
                manager.toConsole(bouquet);
            }
        });
        
        menu.add(new MenuItem("Сортировать цветы в букете по свежести.") {
            @Override
            public void toDo() {
                manager.sort(bouquet, new FreshnessComparator());
                System.out.println("Сортировка завершена...\n");
            }
        });
        
        menu.add(new MenuItem("Поиск цветка по заданному диапазону длин стеблей (в см.)") {
            private Scanner scanner;
            
            @Override
            public void toDo() {
                System.out.println("\tВведите два числа для диапазона в сантиметрах, разделенных пробелами.");
                scanner = new Scanner(System.in);
                String[] values = scanner.nextLine().split(" ");
                Filter filter = new RangeLength(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
                Bouquet result = manager.find(bouquet, filter);
                manager.toConsole(result);
                System.out.println("\tРезультат поиска:");
                manager.toConsole(result);
            }
        });
        
        menu.add(new MenuItem("Выход") {
            @Override
            public void toDo() {
                System.out.println("Done");
            }
        });
        menu.run();
    }
}