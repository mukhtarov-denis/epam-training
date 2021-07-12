package app.console;

public abstract class MenuItem {
    private String description;
    
    public MenuItem(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public abstract void toDo();
}