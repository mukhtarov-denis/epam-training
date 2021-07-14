package app.operation.impl;

import app.entity.bouquet.Bouquet;
import app.operation.Print;

public class PrintImpl implements Print {

    @Override
    public void toConsole(Bouquet bouquet) {
        System.out.printf("Bouquet: size=%d \n%s\n", bouquet.getSize(), bouquet.toString());
        System.out.printf("Price: %.2f ð.\n\n", bouquet.getPrice());
    }
}