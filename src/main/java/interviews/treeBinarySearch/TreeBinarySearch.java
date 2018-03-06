package interviews.treeBinarySearch;

/**
 * Populate, search and traverse through a binary search tree
 */
public class TreeBinarySearch {

    public static void main(String[] args) {

        TreeBinarySearch sol = new TreeBinarySearch();
        sol.start();
    }

    // populate and test search/traverse methods
    public void start() {
        int[] numbers = new int[]{1, 5, 4, 3, 2};

        BinarySearchTree tree = new BinarySearchTree();
        for (int aNumber : numbers) {
            tree.insert(aNumber);
        }

        System.out.println("------------------------");
        boolean value = tree.search(tree.root, 1);
        System.out.println("result: " + value);

        value = tree.search(tree.root, 2);
        System.out.println("result: " + value);

        value = tree.search(tree.root, 3);
        System.out.println("result: " + value);

        value = tree.search(tree.root, 4);
        System.out.println("result: " + value);

        value = tree.search(tree.root, 5);
        System.out.println("result: " + value);

        value = tree.search(tree.root, 6);
        System.out.println("result: " + value);

        System.out.println("------------------------");
        tree.traverse();

    }

    static class BinarySearchTree {

        public Node root;

        public void insert(int value) {
            root = insert(root, value);
        }

        public Node insert(Node node, int value) {

            System.out.println("node: " + (node == null ? null : node.value));

            if (node == null) {
                System.out.println("crate node: " + value);
                node = new Node(value);
            } else if (value < node.value) {
                System.out.println("go left: " + value);
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                System.out.println("go right: " + value);
                node.right = insert(node.right, value);
            }

            return node;
        }


        public boolean search(Node node, int value) {

            if (node == null) {
                return false;
            }
//            System.out.println("node: " + node.value);

            if (node.value == value) {
                return true;
            }

            if (value < node.value) {
//                System.out.println("L");
                return search(node.left, value);
            }

//            System.out.println("R");
            return search(node.right, value);
        }

        public void traverse() {
            if (root != null) {
                traverse(root);
            }
        }

        // ordering is:
        // 1) left nodes first.
        // 2) this node.
        // 3) right nodes last
        public void traverse(Node node) {
            if (node.left != null) {
                traverse(node.left);
            }
            System.out.println("node: " + node.value);
            if (node.right != null) {
                traverse(node.right);
            }
        }
    }

    static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
