package interviews.treeBinarySearch;

public class Tree {

    public static void main(String[] args) {

        TreeNavigator nv = new TreeNavigator();
        nv.insert(23);
        nv.insert(5);
        nv.insert(50);

        nv.traverse();

        System.out.println(nv.search(23));
        System.out.println(nv.search(24));
        System.out.println(nv.search(50));
    }



    public static class TreeNavigator {

        private Node<Integer> root;

        /**
         * Insert
         * @param value
         */
        public void insert(Integer value) {
            root = insert(root, value);
        }

        /**
         * Insert
         *
         * @param node
         * @param value
         * @return
         */
        private Node insert(Node<Integer> node, Integer value) {

            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.leftNode = insert(node.leftNode, value);
            }

            if (value > node.value) {
                node.rightNode = insert(node.rightNode, value);
            }

            return node;
        }

        public void traverse() {
            traverse(root);
        }

        private void traverse(Node<Integer> node) {

            if (node != null){
                traverse(node.leftNode);
                System.out.println(node.value);
                traverse(node.rightNode);
            }
        }


        public boolean search(Integer value) {
            return search(root, value);
        }

        private boolean search(Node<Integer> node, Integer value) {

            if (node == null) {
                return false;
            }

            if (node.value == value) {
                return true;
            }

            if (value < node.value) {
                return search(node.leftNode, value);
            } else {
                return search(node.rightNode, value);
            }
        }



        public static class Node<T> {
            public T value;
            public Node leftNode;
            public Node rightNode;

            public Node(T value) {
                this.value = value;
            }
        }
    }
}
