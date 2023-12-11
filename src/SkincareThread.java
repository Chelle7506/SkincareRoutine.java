import java.util.List;

public class SkincareThread implements Runnable {
    private List<SkincareProduct> skincareProducts;
    private int startIndex;
    private int endIndex;

    public SkincareThread(List<SkincareProduct> skincareProducts, int startIndex, int endIndex) {
        this.skincareProducts = skincareProducts;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            processSkincareProduct(skincareProducts.get(i));
        }
    }

    private void processSkincareProduct(SkincareProduct product) {
        // Add processing logic here
        System.out.println("Processing: " + product.getName());
        // Simulate some work being done
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}