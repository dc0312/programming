package practice.tree.binaryTree;

class Link {
    TreeNode data;
    Link next;

    Link(TreeNode data) {
        this.data = data;
    }
}

class LinkedList {
    Link head;
    Link tail;
    int counter;

    public boolean isEmpty() {
        return null == head;
    }

    public int size() {
        return counter;
    }

    public void insertLast(TreeNode treeNode) {
        Link newLink = new Link(treeNode);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
            counter++;
        } else {
            tail.next = newLink;
            tail = newLink;
            counter++;
        }
    }

    public TreeNode deleteFirst() {
        TreeNode tempNode = null;
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else if (size() == 1) {
            tempNode = head.data;
            head = null;
            tail = null;
            counter--;
        } else {
            tempNode = head.data;
            head = head.next;
            counter--;
        }
        return tempNode;
    }
}

class Queue {
    LinkedList linkedList;

    Queue() {
        linkedList = new LinkedList();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void enqueue(TreeNode treeNode) {
        linkedList.insertLast(treeNode);
    }

    public TreeNode dequeue() {
        return linkedList.deleteFirst();
    }
}


class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }

    public void insert(TreeNode treeNode, int data) {
        Queue customQueue = new Queue();
        customQueue.enqueue(treeNode);
        while (!customQueue.isEmpty()) {
            TreeNode root = customQueue.dequeue();
            if (null == root.leftChild) {
                root.leftChild = new TreeNode(data);
                return;
            } else {
                customQueue.enqueue(root.leftChild);
            }
            if (null == root.rightChild) {
                root.rightChild = new TreeNode(data);
                return;
            } else {
                customQueue.enqueue(root.rightChild);
            }
        }
    }

    public void inOrder(TreeNode rootNode) {
        if (null == rootNode) {
            return;
        } else {
            inOrder(rootNode.leftChild);
            System.out.print(rootNode.data + "->");
            inOrder(rootNode.rightChild);
        }
    }

    public void levelOrder(TreeNode treeNode) {
        Queue customQueue = new Queue();
        customQueue.enqueue(treeNode);
        while (!customQueue.isEmpty()) {
            TreeNode root = customQueue.dequeue();
            System.out.print(root.data + "->");
            if (null != root.leftChild) {
                customQueue.enqueue(root.leftChild);
            }
            if (null != root.rightChild) {
                customQueue.enqueue(root.rightChild);
            }
        }
    }

    public TreeNode findDeepestNode(TreeNode treeNode) {
        Queue customQueue = new Queue();
        customQueue.enqueue(treeNode);
        TreeNode deepNode = null;
        while (!customQueue.isEmpty()) {
            deepNode = customQueue.dequeue();
            if (null != deepNode.rightChild) {
                customQueue.enqueue(deepNode.rightChild);
            }
            if (null != deepNode.leftChild) {
                customQueue.enqueue(deepNode.leftChild);
            }
        }
        return deepNode;
    }

    public TreeNode deleteDeepestNode(TreeNode treeNode) {
        TreeNode deepestNode = treeNode.findDeepestNode(treeNode);
        Queue customQueue = new Queue();
        customQueue.enqueue(treeNode);
        while (!customQueue.isEmpty()) {
            TreeNode root = customQueue.dequeue();
            if (null != root.leftChild) {
                if (root.leftChild == deepestNode) {
                    root.leftChild = null;
                } else {
                    customQueue.enqueue(root.leftChild);
                }
            }
            if (null != root.rightChild) {
                if (root.rightChild == deepestNode) {
                    root.rightChild = null;
                } else {
                    customQueue.enqueue(root.rightChild);
                }
            }
        }
        return deepestNode;
    }

    public boolean delete(TreeNode treeNode, int data) {
        Queue customQueue = new Queue();
        customQueue.enqueue(treeNode);
        while (!customQueue.isEmpty()) {
            TreeNode root = customQueue.dequeue();
            if (root.data == data) {
                TreeNode deepNode = treeNode.findDeepestNode(treeNode);
                root.data = deepNode.data;
                treeNode.deleteDeepestNode(treeNode);
                return true;
            }
            if (null != root.rightChild) {
                customQueue.enqueue(root.rightChild);
            }
            if (null != root.leftChild) {
                customQueue.enqueue(root.leftChild);
            }
        }
        return false;
    }

}

public class BinaryTree {

    TreeNode rootNode;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(11);
        tree.inOrder();
        tree.levelOrder();
        System.out.println("Deepest Node : " + tree.findDeepestNode());
        tree.deleteDeepestNode();
        tree.levelOrder();
//        tree.delete(2);
//        tree.levelOrder();
//        tree.delete(4);
//        tree.levelOrder();
    }

    public void insert(int data) {
        if (null == rootNode) {
            rootNode = new TreeNode(data);
        } else {
            rootNode.insert(rootNode, data);
        }
    }

    public void inOrder() {
        rootNode.inOrder(rootNode);
        System.out.println();
    }

    public void levelOrder() {
        rootNode.levelOrder(rootNode);
        System.out.println();
    }

    public int findDeepestNode() {
        if (null == rootNode) {
            System.out.println("Tree is empty.");
            return -1;
        } else {
            return rootNode.findDeepestNode(rootNode).data;
        }
    }

    public int deleteDeepestNode() {
        if (null == rootNode) {
            System.out.println("Tree is empty.");
            return -1;
        } else {
            return rootNode.deleteDeepestNode(rootNode).data;
        }
    }

    public void delete(int data) {
        if (null == rootNode) {
            System.out.println("Tree is empty.");
            return;
        } else {
            boolean isDeleted = rootNode.delete(rootNode, data);
            System.out.println("Data deleted ? " + isDeleted);
        }
    }
}
