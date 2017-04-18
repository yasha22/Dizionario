
package dizionario_albero_stringhe;

/**
 *
 * @author Yasser
 * @param <E>
 */
public class Node<E>
{

    private E key;
    private Node<E> left;
    private Node<E> right;

    public Node(E key)
    {
        this.key = key;
        left = null;
        right = null;
    }

    public void setKey(E key)
    {
       this.key = key;
    }

    /**
     *
     * @return the key
     */
    public E getKey()
    {
       return key;
    }

    public void setLeft(Node<E> node)
    {
       left = node;
    }

    public Node<E> getLeft()
    {
       return left;
    }

    public void setRight(Node<E> node)
    {
       right = node;
    }

    public Node<E> getRight()
    {
       return right;
    }

    public boolean isLeaf()
    {
       return left==null && right==null;
    }
    
}
