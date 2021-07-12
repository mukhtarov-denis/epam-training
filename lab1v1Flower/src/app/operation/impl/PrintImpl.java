package app.operation.impl;

import app.entity.bouquet.Bouquet;
import app.operation.Print;

public class PrintImpl implements Print {

    @Override
    public void toConsole(Bouquet bouquet) {
        System.out.printf("Bouquet: %s\n", bouquet.getDescription());
        System.out.printf("Price: %.2f ð.\n", bouquet.getPrice());
    }
}