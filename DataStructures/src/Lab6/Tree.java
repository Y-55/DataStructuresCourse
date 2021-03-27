/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author Yusuf Abdullah Abdulwahab
 */
class Tree {

    private TNode root;             // first node of tree

// -------------------------------------------------------------
    public Tree() // constructor
    {
        root = null;
    }            // no nodes in tree yet
// -------------------------------------------------------------

    public Lab6.TNode getRoot() {
        return root;
    }

    public void setRoot(Lab6.TNode root) {
        this.root = root;
    }

    public TNode find(int key) // find node with given key
    {                           // (assumes non-empty tree)
        TNode current = getRoot();               // start at root
        while (current.getiData() != key) // while no match,
        {
            if (key < current.getiData()) // go left?
            {
                current = current.getLeftChild();
            } else // or go right?
            {
                current = current.getRightChild();
            }
            if (current == null) // if no child,
            {
                return null;                 // didn't find it
            }
        }
        return current;                    // found it
    }  // end find()

    public boolean find(int e, TNode n) {
        if (n == null) {
            return false;
        }
        if (e == n.getiData()) {
            return true;
        }
        if (e < n.getiData()) {
            return find(e, n.getLeftChild());
        } else {
            return find(e, n.getRightChild());
        }
    }

    public TNode findMax() {
        TNode max = getRoot();
        if (getRoot() != null) {
            while (max.getRightChild() != null) {
                max = max.getRightChild();
            }
            return max;
        } else {
            return null;
        }
    }

    public TNode findMax(TNode r) {
        if (r == null) {
            return null;
        }
        if (r.getRightChild() == null) {
            return r;
        } else {
            return findMax(r.getRightChild());
        }
    }

    public TNode findMin() {
        TNode min = getRoot();
        if (getRoot() != null) {
            while (min.getLeftChild() != null) {
                min = min.getLeftChild();
            }
            return min;
        } else {
            return null;
        }
    }

    public TNode findMin(TNode r) {
        if (r == null) {
            return null;
        }
        if (r.getLeftChild() == null) {
            return r;
        } else {
            return findMin(r.getLeftChild());
        }
    }
// -------------------------------------------------------------

    public void insert(int id) {
        TNode newNode = new TNode(id);    // make new node                   
        if (getRoot() == null) // no node in root
        {
            setRoot(newNode);
        } else // root occupied
        {
            TNode current = getRoot();       // start at root
            TNode parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (id < current.getiData()) // go left?
                {
                    current = current.getLeftChild();
                    if (current == null) // if end of the line,
                    {                 // insert on left
                        parent.setLeftChild(newNode);
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.getRightChild();
                    if (current == null) // if end of the line
                    {                 // insert on right
                        parent.setRightChild(newNode);
                        return;
                    }
                }  // end else go right
            }  // end while
        }  // end else not root
    }  // end insert()
// -------------------------------------------------------------

    public boolean delete(int key) // delete node with given key
    {                           // (assumes non-empty list)
        TNode current = getRoot();
        TNode parent = getRoot();
        boolean isLeftChild = true;

        while (current.getiData() != key) // search for node
        {
            parent = current;
            if (key < current.getiData()) // go left?
            {
                isLeftChild = true;
                current = current.getLeftChild();
            } else // or go right?
            {
                isLeftChild = false;
                current = current.getRightChild();
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
            TNode successor = getSuccessor(current);

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
// -------------------------------------------------------------
    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendents

    private TNode getSuccessor(TNode delNode) {
        TNode successorParent = delNode;
        TNode successor = delNode;
        TNode current = delNode.getRightChild();   // go to right child
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
// -------------------------------------------------------------

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
// -------------------------------------------------------------

    private void preOrder(TNode localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.getiData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    public void preOrder() {

        Stack<TNode> s = new Stack<>();
        TNode current = getRoot();
        s.push(getRoot());

        while (!s.isEmpty()) {
            if (current != null) {
                current = s.pop();
                current.displayNode();
                if (current.getRightChild() != null) {
                    s.push(current.getRightChild());
                }
                if (current.getLeftChild() != null) {
                    s.push(current.getLeftChild());
                }
            }
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    private void inOrder(TNode localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getiData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    public void inOrder() {
        Stack<TNode> nodes = new Stack<>();
        TNode current = getRoot();
        while (current != null || !nodes.isEmpty()) {

            if (current != null) {

                nodes.push(current);
                current = current.getLeftChild();
            } else {

                TNode newT = (TNode) nodes.pop();
                newT.displayNode();
                current = newT.getRightChild();
            }
        }
        System.out.println("");
    }
// -------------------------------------------------------------

    private void postOrder(TNode localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.println(localRoot.getiData() + " ");
        }
    }

    public void postOrder() {//----------------------------------Working-------------------------------------------------------------
        Stack<TNode> stack1 = new Stack<>();
        Stack<TNode> stack2 = new Stack<>();
        TNode current = getRoot();
        stack1.push(current);

        while (!stack1.isEmpty()) {
            current = stack1.pop();
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
// -------------------------------------------------------------

    public void displayTree() {
    }  // end displayTree()
// -------------------------------------------------------------

    public void levelOrder() {
        Queue<TNode> queue = new Queue<>();
        TNode current = getRoot();
        queue.enqueue(current);

        while (!queue.isEmpty()) {
            current = queue.dequeue();
            current.displayNode();

            if (current.getLeftChild() != null) {
                queue.enqueue(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.enqueue(current.getRightChild());
            }

        }
        System.out.println("");
    }
// -------------------------------------------------------------

    private boolean depthFirst(int e, TNode n) {
        Stack<TNode> stack = new Stack<>();
        boolean found = false;
        if (n != null) {
            stack.push(n);
            do {
                TNode node = stack.pop();

                if (node.getiData() == e) //use compareTo here
                {
                    found = true;
                } else {

                    if (n.getRightChild() != null) {
                        stack.push(n.getRightChild());
                    }
                    if (n.getLeftChild() != null) {
                        stack.push(n.getLeftChild());
                    }
                }

            } while (!found && !stack.isEmpty());
        }
        return found;
    }

    public int count(TNode n) {
        int counter = 0;
        if (n == null) {
            return 0;
        } else {
            counter++;
            counter = counter + (count(n.getRightChild()));
            counter = counter + (count(n.getLeftChild()));
        }

        return counter;
    }//end(count(TNode n)

    public int count() {
        int counter = 0;
        Stack<TNode> stack = new Stack<>();
        stack.push(getRoot());
        while (!stack.isEmpty()) {
            TNode x = stack.pop();
            if (x != null) {
                counter++;
            }
            if (x.getRightChild() != null) {
                stack.push(x.getRightChild());
            }
            if (x.getLeftChild() != null) {
                stack.push(x.getLeftChild());
            }
        }
        return counter;
    }//end count()

    public void printTree() {
        TNode x = new TNode(-1);
        Queue<TNode> store = new Queue<>();
        Queue<TNode> print = new Queue<>();
        print.enqueue(getRoot());
        int counter = 0;
        while ((!print.isEmpty() || !store.isEmpty()) && counter < 20) {
            while (!print.isEmpty()) {
                TNode temp = print.dequeue();
                if (temp.getiData() == -1) {
                    store.enqueue(x);
                    store.enqueue(x);
                    System.out.print("{-} ");
                    counter++;
                } else {
                    if (temp.getLeftChild() != null) {
                        store.enqueue(temp.getLeftChild());
                    } else {
                        store.enqueue(x);
                    }
                    if (temp.getRightChild() != null) {
                        store.enqueue(temp.getRightChild());
                    } else {
                        store.enqueue(x);
                    }
                    counter++;
                    temp.displayNode();
                }

            }
            System.out.println("");
            while (!store.isEmpty()) {
                print.enqueue(store.dequeue());
            }
        }
    }

    public void printTree(int a) {

        Queue<TNode> store = new Queue<>();
        Queue<TNode> print = new Queue<>();
        print.enqueue(getRoot());
        int counter = getNumberOfLevels();       
        while (counter > 0) {
            while (!print.isEmpty()) {

                TNode temp = print.dequeue();
                if (temp == null) {
                    store.enqueue(null);
                    store.enqueue(null);
                    System.out.print("{--} ");                   
                } else {
                    if (temp.getLeftChild() != null) {
                        store.enqueue(temp.getLeftChild());
                    } else {
                        store.enqueue(null);
                    }
                    if (temp.getRightChild() != null) {
                        store.enqueue(temp.getRightChild());
                    } else {
                        store.enqueue(null);
                    }
                    temp.displayNode();                  
              }

            }           
            counter--;//counter for levels to leave when all levels are prenter           
            System.out.println("");           
            while (!store.isEmpty()) {
                print.enqueue(store.dequeue());
            }
        }
    }
    public void printTree(char z) {

        Queue<TNode> store = new Queue<>();
        Queue<TNode> print = new Queue<>();
        print.enqueue(getRoot());
        int counter = getNumberOfLevels();
        int counter2 = counter - 1;
        int current = 0;
        int init = (int) (Math.pow(2, counter2) * 5 / 2 - Math.pow(2, current) * 5 / 2);       
        for (int i = 0; i < init; i++) {
            System.out.print(" ");
        }
        while (counter > 0) {
            while (!print.isEmpty()) {

                TNode temp = print.dequeue();
                if (temp == null) {
                    store.enqueue(null);
                    store.enqueue(null);
                    System.out.print("{--} ");
                    for (int i = 0; i < counter; i++) {
                        System.out.print("  ");
                    }

                } else {
                    if (temp.getLeftChild() != null) {
                        store.enqueue(temp.getLeftChild());
                    } else {
                        store.enqueue(null);
                    }
                    if (temp.getRightChild() != null) {
                        store.enqueue(temp.getRightChild());
                    } else {
                        store.enqueue(null);
                    }
                    temp.displayNode();
                    for (int i = 0; i < counter; i++) {
                        System.out.print("  ");
                    }
                }

            }
            //counter2--;//counter to current level
            counter--;//counter for levels to leave when all levels are prenter
            current++;

            init = (int) (Math.pow(2, counter2) * 5 / 2 - Math.pow(2, current) * 5 / 2);
            System.out.println("");
            for (int i = 0; i < init; i++) {
                System.out.print(" ");
            }
            while (!store.isEmpty()) {
                print.enqueue(store.dequeue());
            }
        }
    }

    public int getNumberOfLevels() {
        Queue<TNode> store = new Queue<>();
        Queue<TNode> print = new Queue<>();
        print.enqueue(getRoot());
        int counter = 0;
        while ((!print.isEmpty() || !store.isEmpty())) {
            while (!print.isEmpty()) {
                TNode temp = print.dequeue();

                if (temp.getLeftChild() != null) {
                    store.enqueue(temp.getLeftChild());
                }
                if (temp.getRightChild() != null) {
                    store.enqueue(temp.getRightChild());
                }
            }
            counter++;
            while (!store.isEmpty()) {
                print.enqueue(store.dequeue());
            }

        }
        return counter;
    }
}  // end class Tree
