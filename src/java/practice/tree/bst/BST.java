package practice.tree.bst;

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
            if (data < root.data) {
                if (null == root.leftChild) {
                    root.leftChild = new TreeNode(data);
                    return;
                } else {
                    customQueue.enqueue(root.leftChild);
                }
            } else {
                if (null == root.rightChild) {
                    root.rightChild = new TreeNode(data);
                    return;
                } else {
                    customQueue.enqueue(root.rightChild);
                }
            }
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

    public TreeNode min(TreeNode rootNode) {
        TreeNode minNode = rootNode;
        while (null != minNode.leftChild) {
            minNode = minNode.leftChild;
        }
        return minNode;
    }

    public TreeNode delete(TreeNode rootNode, int data) {
        Queue customQueue = new Queue();
        customQueue.enqueue(rootNode);
        if (data < rootNode.data) {
            rootNode.leftChild = delete(rootNode.leftChild, data);
        } else if (data > rootNode.data) {
            rootNode.rightChild = delete(rootNode.rightChild, data);
        } else {
            TreeNode temp;
            if (null == rootNode.leftChild) {
                temp = rootNode.rightChild;
                rootNode = null;
                return temp;
            }
            if (null == rootNode.rightChild) {
                temp = rootNode.leftChild;
                rootNode = null;
                return temp;
            }
            temp = min(rootNode.rightChild);
            rootNode.data = temp.data;
            rootNode.rightChild = delete(rootNode.rightChild, temp.data);
        }
        return rootNode;
    }
}

public class BST {
    TreeNode rootNode;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(6);
        bst.insert(15);
        bst.insert(8);
        bst.insert(2);
        bst.insert(20);
        bst.insert(12);
        bst.insert(18);
        bst.insert(25);
        bst.levelOrderTraversal();
        System.out.println("Minimum data : " + bst.min());
        bst.delete(6);
        bst.levelOrderTraversal();
    }

    public void insert(int data) {
        if (null == rootNode) {
            rootNode = new TreeNode(data);
        } else {
            rootNode.insert(rootNode, data);
        }
    }

    public void levelOrderTraversal() {
        if (null == rootNode) {
            System.out.println("Tree is empty.");
        } else {
            rootNode.levelOrder(rootNode);
            System.out.println();
        }
    }

    public int min() {
        if (null == rootNode) {
            System.out.println("Tree is empty.");
            return -1;
        } else {
            return rootNode.min(rootNode).data;
        }
    }

    public TreeNode delete(int data) {
        if (null == rootNode) {
            System.out.println("Queue is empty.");
            return null;
        } else {
            return rootNode.delete(rootNode, data);
        }
    }
}
