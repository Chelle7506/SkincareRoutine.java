public class SkincareProduct {
    private String name;
    private String category;

    public SkincareProduct(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ")";
    }
}