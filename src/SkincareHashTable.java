import java.util.LinkedList;
public class SkincareHashTable {
    private static final int TABLE_SIZE = 10; // Adjust the table size as needed
    private LinkedList<SkincareProduct>[] table;

    public SkincareHashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    public void put(String key, SkincareProduct value) {
        int index = hash(key);
        LinkedList<SkincareProduct> bucket = table[index];

        // Check if the key already exists in the table, update the value if it does
        for (SkincareProduct product : bucket) {
            if (product.getName().equals(key)) {
                // Update the existing product
                product = value;
                return;
            }
        }

        // Add a new key-value pair
        bucket.add(value);
    }

    public SkincareProduct get(String key) {
        int index = hash(key);
        LinkedList<SkincareProduct> bucket = table[index];

        // Search for the key in the linked list
        for (SkincareProduct product : bucket) {
            if (product.getName().equals(key)) {
                return product;
            }
        }

        // Key not found
        return null;
    }

    // Other methods like remove, printTable, etc., can be added based on requirements
}