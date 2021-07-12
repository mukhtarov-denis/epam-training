package app.factory;

import app.operation.impl.Manager;

public class BouquetFactory {
    private static Manager manager;
    
    private BouquetFactory() {
        
    }
    
    public static Manager getInstance() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }
}