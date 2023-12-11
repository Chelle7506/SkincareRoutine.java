public class SkincareBST {
    private SkincareProductNode root;

    public SkincareBST() {
        this.root = null;
    }

    public void insert(SkincareProduct product) {
        root = insertRec(root, product);
    }

    private SkincareProductNode insertRec(SkincareProductNode root, SkincareProduct product) {
        if (root == null) {
            root = new SkincareProductNode(product);
            return root;
        }

        if (product.getName().compareTo(root.product.getName()) < 0) {
            root.left = insertRec(root.left, product);
        } else if (product.getName().compareTo(root.product.getName()) > 0) {
            root.right = insertRec(root.right, product);
        }

        return root;
    }

    public SkincareProduct search(String productName) {
        return searchRec(root, productName);
    }

    private SkincareProduct searchRec(SkincareProductNode root, String productName) {
        if (root == null || root.product.getName().equals(productName)) {
            return (root != null) ? root.product : null;
        }

        if (productName.compareTo(root.product.getName()) < 0) {
            return searchRec(root.left, productName);
        } else {
            return searchRec(root.right, productName);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(SkincareProductNode root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.println(root.product);
            inOrderTraversalRec(root.right);
        }
    }

    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(SkincareProductNode root, int spaces) {
        if (root != null) {
            printTreeRec(root.right, spaces + 5);
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
            System.out.println(root.product);
            printTreeRec(root.left, spaces + 5);
        }
    }
}