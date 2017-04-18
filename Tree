
package dizionario_albero_stringhe;

/**
 *
 * @author Yasser
 * @param <E>
 */
public class Tree<E extends Comparable<E>>  implements BinaryTree<E>
{
    
    protected Node<E> root;
    public Tree()
    {
        this.root = null;
    }

    /**
     *
     * @param lTree
     * @param key
     * @param rTree
     */
    public Tree(Tree<E> lTree, E key, Tree<E> rTree)
    {
        root = new Node<>(key);
        root.setLeft(lTree.root);
        root.setRight(rTree.root);
    }

    /**
     *
     * @return root
     * @throws TreeExeption
     */
    @Override
    public E root() throws TreeExeption
    {
        if(isEmpty())
            throw  new TreeExeption("Impossibile trovare la radice di un albero vuoto");
        
        return root.getKey();
    }

    /**
     *
     * @return left subTree
     * @throws TreeExeption
     */
    @Override
    public Tree leftSubTree() throws TreeExeption
    {
        if(isEmpty())
            throw new TreeExeption("Impossibile ottenere il sottoalbero di un albero vuoto");
        
        Tree<E> lTree = new Tree<E>();
        lTree.root = root.getLeft();

        return lTree;
    }
    
    /**
     *
     * @return right subTree
     * @throws TreeExeption
     */
    @Override
    public Tree<E> rightSubTree() throws TreeExeption
    {
        if(isEmpty())
            throw new TreeExeption("Impossibile ottenere il sottoalbero di un albero vuoto");
    
        Tree<E> lTree = new Tree<E>();
        lTree.root = root.getRight();

        return lTree;
    }
    
    /**
     *
     * @return true if it's empty
     */
    @Override
    public boolean isEmpty()
    {
        return root==null;
    }

    /**
     *
     * @param value
     * @return true if value is present
     */
    @Override
    public boolean isPresent(E value)
    {
        return isPresent(root,value);
    }

    private boolean isPresent(Node<E> node, E value)
    {
        if(node == null)
            return false;
        if(node.getKey().compareTo(value) == 0)
            return true;
        else
            return isPresent(node.getLeft(), value) || isPresent(node.getRight(), value);
    }

    /**
     *
     * @return number of nodes
     */
    @Override
    public int count()
    {
        return count(root);
    }

    private int count(Node node)
    {
        if(node == null)
            return 0;
        
        return count(node.getLeft()) + count(node.getRight()) + 1;
    }

    @Override
    public void visitPre()
    {
        visitPre(root);
        System.out.println();
    }

    private void visitPre(Node node)
    {
        if(node==null)
            return;
        
        //visita ricorsiva in preorder
        System.out.print(node.getKey()+" ");
        visitPre(node.getLeft());
        visitPre(node.getRight());
    }
    @Override
    public void visitIn()
    {
        visitIn(root);
        System.out.println();
    }

    private void visitIn(Node node)
    {
        if(node==null)
            return;
        
        //visita ricorsiva inorder
        visitIn(node.getLeft());
        System.out.print(node.getKey()+" ");
        visitIn(node.getRight());
        
    }

    @Override
    public void visitPost()
    {
        visitPost(root);
        System.out.println();
    }

    private void visitPost(Node node)
    {
        if(node==null)
            return;
       
        //visita ricorsiva in postorder
        visitPost(node.getLeft());
        visitPost(node.getRight());
        System.out.print(node.getKey()+" ");
        
    }
    
    @Override
    public String toString()
    {
        return toStringR(root);
    }

    private String toStringR(Node<E> node)
    {
        
        if(node == null)
            return "()";
        return "(" + node.getKey() + 
            " " + toStringR(node.getLeft()) +
            " " + toStringR(node.getRight()) + ")";
 }

    /**
     *
     * @return true if it's BST
     */
    @Override
    public boolean isBST()
    {
        return isBST(root);
    }
   
    private boolean isBST(Node<E> node)
    {
        if(node == null)
            return true;
        
        Node<E> newLeft = node.getLeft();
        Node<E> newRight = node.getRight();
        
        if(newLeft.getKey().compareTo(node.getKey()) > 0 && node.getLeft()!=null)
            return false;
        
        if(newRight.getKey().compareTo(node.getKey()) > 0 && node.getRight()!=null)
            return false;
       
        return isBST(node.getLeft()) && isBST(node.getRight());
    }
   
    /**
     *
     * @return true if it's balanced
     */
    @Override
    public boolean isBalanced()
    {
        return isBalanced(root);
    }
   
    private boolean isBalanced(Node node)
    {
        if(node == null)
            return true;
        int num=height(node.getLeft())-height(node.getRight());
        if(num<0)
            num=-num;
        return (isBalanced(node.getLeft()) && isBalanced(node.getRight()));
    }
   
    /**
     *
     * @return true if it's complete
     */
    @Override
    public boolean isComplete()
    {
        return isComplete(root);
    }
   
    private boolean isComplete(Node node)
    {
        if(node==null)
            return true;
        // int num=height(node.getLeft())-height(node.getRight());
        //if(num<0)
        //    num=-num;
        return (isBalanced(node.getLeft()) && isBalanced(node.getRight()));
    }
   
    /**
     * 
     * @return true if is linked list
     */
    @Override
    public boolean isLinkedList()
    {
        return isLinkedList(root);
    }
   
    private boolean isLinkedList(Node node)
    {
        if(node==null)
            return true;
        if((node.getLeft()==null && node.getRight()!=null) ||
            (node.getLeft()!=null && node.getRight()==null))
            return true;
        if(node.getLeft()!=null && node.getRight()!=null)
            return false;
       
        return (isLinkedList(node.getLeft()) && isLinkedList(node.getRight()));
    }
    
    public Node getRoot()
    {
        return root;
    }
    
    public void setRoot(Node<E> node)
    {
        root = node;
    }
    
    /**
     *
     * @return the hight of the tree
     */
    @Override
    public int height()
    {
        return height(root);
    }
    
    /**
     *
     * @param node
     * @return the height of a node
     */
    protected int height(Node node)
    {
        if(node==null)
            return -1;
        return Math.max(height(node.getLeft()),height(node.getRight()))+1;
    }   
    
}
