
package dizionario_albero_stringhe;

/**
 *
 * @author Yasser
 * @param <E>
 */
public class AVLTree<E extends Comparable<E>> extends BSTree<E>
{
    private static int count;
    private String id;
    
    public AVLTree()
    {
        super();
        id = "Dizionario"+count;
        count++;
    }

    public AVLTree(String id)
    {
        super();
        this.id = id;
        count++;
    }
    
    /**
     *
     * @param key
     */
    @Override
    public void insert(E key)
    {
       root = insert(root, key);
    }
    
    private Node<E> insert(Node<E> node, E key)
    {  
        // Eseguo un normale inserimento BST
        if (node == null)
            node = new Node(key);        
        
        else if(key.compareTo(node.getKey()) < 0)
            node.setLeft(insert(node.getLeft(), key));
        
        else
            node.setRight(insert(node.getRight(), key));
               
        return reBalance(node);   
        
    }
    
    /**
     *
     * @param key
     */
    @Override
    public void delete(E key)
    {
        delete(root, key);
    }
    
    
    private Node<E> delete(Node<E> node, E key)
    {
        //se l'albero è vuoto lo restituisco cosi com'è
        if(node == null)
            return node;
        
        if(key.compareTo(node.getKey()) < 0)
            node.setLeft(delete(node.getLeft(), key));
        
        else if(key.compareTo(node.getKey()) > 0)
            node.setRight(delete(node.getRight(), key));
        
        else
        {
            if(node.getLeft() == null)
                return node.getRight();

            else if(root.getRight() == null)
                return node.getLeft();

            node.setKey((E) getMinimum(node.getRight()).getKey());
            node.setRight(delete(node.getRight(), node.getKey()));
        }
        
        return reBalance(node);
    }
    
    
    
    private Node<E> rotateRight(Node<E> node)
    {
        Node<E> newNode = node.getLeft();
 
        // Eseguo la rotazione    
        node.setLeft(newNode.getRight());
        newNode.setRight(node);
        
        return newNode;
    }
    
    private Node<E> rotateLeft(Node<E> node)
    {
        Node<E> newNode = node.getRight();
 
        // Eseguo la rotazione    
        node.setRight(newNode.getLeft());
        newNode.setLeft(node);
        
        return newNode;
    }
    
    private Node<E> rotateLeftRight(Node<E> node)
    {
        Node<E> newNode = node.getLeft();
        Node<E> newLeft = rotateLeft(newNode);
        
        node.setLeft(newLeft);
        
        return rotateRight(node);
        
    }
    
    private Node<E> rotateRightLeft(Node<E> node)
    {
        Node<E> newNode = node.getRight();
        Node<E> newRight = rotateRight(newNode);
        
        node.setRight(newRight);
        
        return rotateLeft(node);
        
    }
    
    private Node<E> reBalance(Node<E> node)        
    {   

        /* Se la differenza tra il sotto albero
        sinistro e destro del nodo è maggiore di 1*/
        if(height(node.getLeft()) > height(node.getRight()) + 1)     
        {   
            /*se il sotto albero del figlio sinistro 
            del nodo è piu alto di quello sinistro*/
            if(height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
                node = rotateRight(node);
            else
                node = rotateLeftRight(node);
        }    
        
        else if(height(node.getRight()) > height(node.getLeft()) + 1)
        {
            if(height(node.getRight().getRight()) > height(node.getRight().getLeft()))
                node = rotateLeft(node);           
            else
                node = rotateRightLeft(node);      
        }

        return node;
        
    }
    
    @Override
    public String toString()
    {
        return id;
    }
    
}
