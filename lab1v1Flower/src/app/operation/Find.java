package app.operation;

import app.entity.bouquet.Bouquet;
import app.filter.Filter;

public interface Find {
    Bouquet find(Bouquet bouquet, Filter filter);
}