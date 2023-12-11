public class SkincareProductNode {
    SkincareProduct product;
    SkincareProductNode left, right;

    public SkincareProductNode(SkincareProduct product) {
        this.product = product;
        this.left = this.right = null;
    }
}