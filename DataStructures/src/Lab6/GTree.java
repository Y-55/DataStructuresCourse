/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 * @param <T>
 */
public class GTree<T extends Comparable> {

    protected GTNode<T> root;

    public GTree() {
        root = null;
    }

    public GTNode<T> getRoot() {
        return root;
    }

    public void setRoot(GTNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return getRoot() == null;
    }
//------------------------------------------------------------------------------------------------------

    public boolean find(T x, GTNode<T> a) {
        if (a == null) {
            return false;
        }
        if (x.equals(a.getiData())) {
            return true;
        }
        if (x.compareTo(a.getiData()) > 0) {
            return find(x, a.getRightChild());
        } else {
            return find(x, a.getLeftChild());
        }

    }

    public boolean find(T x) {
        GTNode<T> current = getRoot();
        while (current != null) {
            if (x == current.getiData()) {
                return true;
            }
            if (x.compareTo(current.getiData()) > 0) {
                current = current.getRightChild();
            } else {
                current = current.getLeftChild();
            }
        }
        return false;
    }

    private boolean depthFirst(T e, GTNode<T> n) {
        Stack<GTNode<T>> stack = new Stack<>();
        stack.push(n);
        boolean found = false;

        while (!stack.isEmpty()) {
            GTNode current = stack.pop();

            if (e.equals(n.getiData())) {
                found = true;
                return found;
            }

            if (current.getRightChild() != null) {
                stack.push(current.getRightChild());
            }
            if (current.getLeftChild() != null) {
                stack.push(current.getLeftChild());
            }
        }
        return found;
    }

    public T findMax() {
        GTNode<T> max = getRoot();
        if (!isEmpty()) {
            while (max.getRightChild() != null) {
                max = max.getRightChild();
            }
            return max.getiData();
        } else {
            return null;
        }
    }

    public T findMax(GTNode<T> a) {
        if (a.getiData() == null) {
            return null;
        }
        if (a.getRightChild() == null) {
            return a.getiData();
        } else {
            return (T) findMax(a.getRightChild());
        }
    }

    public T findMin() {
        GTNode<T> min = getRoot();
        if (!isEmpty()) {
            while (min.getLeftChild() != null) {
                min = min.getLeftChild();
            }
            return min.getiData();
        } else {
            return null;
        }
    }

    public T findMin(GTNode<T> a) {
        if (a == null) {
            return null;
        }
        if (a.getLeftChild() != null) {
            return (T) findMin(a.getLeftChild());
        } else {
            return a.getiData();
        }
    }
//------------------------------------------------------------------------------------------------------

    public void insert(T id) {
        GTNode<T> newNode = new GTNode<>(id);

        if (isEmpty()) {
            setRoot(newNode);
        } else {
            GTNode<T> current = getRoot();
            while (true) {
                if (id.compareTo(current.getiData()) > 0) {
                    if (current.getRightChild() != null) {
                        current = current.getRightChild();
                    } else {
                        current.setRightChild(newNode);
                        return;
                    }
                } else {
                    if (current.getLeftChild() != null) {
                        current = current.getLeftChild();
                    } else {
                        current.setLeftChild(newNode);
                        return;
                    }
                }
            }
        }
    }
//------------------------------------------------------------------------------------------------------

    public boolean delete(T key) // delete node with given key
    {                           // (assumes non-empty list)
        GTNode<T> current = getRoot();
        GTNode<T> parent = getRoot();
        boolean isLeftChild = true;

        while (!current.getiData().equals(key)) // search for node
        {
            parent = current;
            if (key.compareTo(current.getiData()) > 0) // go left?
            // or go right?
            {
                isLeftChild = false;
                current = current.getRightChild();
            } else {
                isLeftChild = true;
                current = current.getLeftChild();
            }
            if (current == null) // end of the line,
            {
                return false;                // didn't find it
            }
        }  // end while
        // found node to delete

        // if no children, simply delete it
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == getRoot()) // if root,
            {
                setRoot(null);                 // tree is empty
            } else if (isLeftChild) {
                parent.setLeftChild(null);     // disconnect
            } else // from parent
            {
                parent.setRightChild(null);
            }
        } // if no right child, replace with left subtree
        else if (current.getRightChild() == null) {
            if (current == getRoot()) {
                setRoot(current.getLeftChild());
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getRightChild());

            }
        } // if no left child, replace with right subtree
        else if (current.getLeftChild() == null) {
            if (current == getRoot()) {
                setRoot(current.getRightChild());

            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());

            } else {
                parent.setRightChild(current.getRightChild());

            }
        } else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            GTNode<T> successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == getRoot()) {
                setRoot(successor);

            } else if (isLeftChild) {
                parent.setLeftChild(successor);

            } else {
                parent.setRightChild(successor);
            }

            // connect successor to current's left child
            successor.setLeftChild(current.getLeftChild());
        }  // end else two children
        // (successor cannot have a left child)
        return true;                                // success
    }  // end delete()

    private GTNode<T> getSuccessor(GTNode<T> delNode) {
        GTNode<T> successorParent = delNode;
        GTNode<T> successor = delNode;
        GTNode<T> current = delNode.getRightChild();   // go to right child
        while (current != null) // until no more
        {                                 // left children,
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();      // go to left child
        }
        // if successor not
        if (successor != delNode.getRightChild()) // right child,
        {                                 // make connections
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }
//------------------------------------------------------------------------------------------------------

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3:
                System.out.println("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

//------------------------------------------------------------------------------------------------------
    private void preOrder(GTNode<T> a) {
        if (a != null) {
            a.displayNode();
            preOrder(a.getLeftChild());
            preOrder(a.getRightChild());
        }
    }

    public void preOrder() {
        if (!isEmpty()) {
            Stack<GTNode<T>> stack = new Stack<>();
            stack.push(getRoot());
            while (!stack.isEmpty()) {
                GTNode<T> current = stack.pop();
                current.displayNode();
                if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                }
                if (current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                }
            }
            System.out.println("");
        }
    }

//------------------------------------------------------------------------------------------------------
    private void inOrder(GTNode<T> a) {
        if (a != null) {
            inOrder(a.getLeftChild());
            a.displayNode();
            inOrder(a.getRightChild());
        }
    }

    public void inOrder() {
        if (!isEmpty()) {
            Stack<GTNode<T>> stack = new Stack<>();
            GTNode<T> current = (getRoot());

            while (!stack.isEmpty() || current != null) {

                if (current != null) {
                    stack.push(current);
                    current = current.getLeftChild();
                } else {
                    GTNode<T> newNode = stack.pop();
                    newNode.displayNode();
                    current = newNode.getRightChild();
                }
            }
            System.out.println("");
        }
    }

//------------------------------------------------------------------------------------------------------
    private void postOrder(GTNode<T> a) {
        if (a != null) {
            postOrder(a.getLeftChild());
            postOrder(a.getRightChild());
            a.displayNode();
        }
    }

    public void postOrder() {
        if (!isEmpty()) {
            Stack<GTNode<T>> stack1 = new Stack<>();
            Stack<GTNode<T>> stack2 = new Stack<>();
            stack1.push(getRoot());

            while (!stack1.isEmpty()) {
                GTNode<T> current = stack1.pop();
                stack2.push(current);
                if (current.getLeftChild() != null) {
                    stack1.push(current.getLeftChild());
                }
                if (current.getRightChild() != null) {
                    stack1.push(current.getRightChild());
                }

            }
            while (!stack2.isEmpty()) {
                stack2.pop().displayNode();
            }
            System.out.println("");
        }
    }

//------------------------------------------------------------------------------------------------------
    public void levelOrder() {
        Queue<GTNode<T>> queue = new Queue<>();
        queue.enqueue(getRoot());

        while (!queue.isEmpty()) {
            GTNode current = queue.dequeue();
            current.displayNode();

            if (current.getLeftChild() != null) {
                queue.enqueue(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.enqueue(current.getRightChild());
            }

        }

    }

//------------------------------------------------------------------------------------------------------
    public int count() {
        int counter = 0;
        if (!isEmpty()) {

            Stack<GTNode<T>> stack = new Stack<>();
            stack.push(getRoot());

            while (!stack.isEmpty()) {
                GTNode current = stack.pop();
                if (current != null) {
                    counter++;
                }
                if (current.getRightChild() != null) {
                    stack.push(current.getRightChild());
                }
                if (current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                }
            }
        }
        return counter;
    }

    public int count(GTNode<T> a) {
        int counter = 0;
        if (a == null) {
            return counter;
        } else {

            counter++;
            counter += count(a.getLeftChild());
            counter += count(a.getRightChild());
        }

        return counter;
    }
//------------------------------------------------------------------------------------------------------
}
