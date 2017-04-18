
package dizionario_albero_stringhe;

import javax.swing.DefaultListModel;

public class BSTree<E extends Comparable<E>> extends Tree<E> implements BST<E>
{
    
    public BSTree()
    {
        super();
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
        if(node == null)
            node = new Node<E>(key);
        
        else
        {
            if(key.compareTo(node.getKey()) < 0)
                node.setLeft(insert(node.getLeft(), key));
            else
                node.setRight(insert(node.getRight(), key));
        }
        return node;
    }

    /**
     *
     * @param key
     * @return true if the key exists in the tree
     */
    @Override
    public boolean find(E key) 
    {
        //Variabile che conterrà il nodo puntato
        Node<E> nodoPuntato = root;
        
        /*Finchè punto a un Nodo(cioè sono all'intenro dell'albero)
        ripeto il ciclo*/
        while(nodoPuntato != null)
        {
            /*Se il nodo puntato contiene la chiave che sto cercando
             ritorno "Vero" */
            if(nodoPuntato.getKey().compareTo(key) == 0)
                return true;
            
            /*In caso contrario mi sposto nel sottoalbero destro o sinistro
            in base al risultato della comparazione tra chiave del nodo puntato
            e chiave ricercata */
            if(nodoPuntato.getKey().compareTo(key) > 0)
                //mi sposto nel sottoalbero sinistro
                nodoPuntato = nodoPuntato.getLeft();
            else
                //mi sposto nel sottoalbero destro
                nodoPuntato = nodoPuntato.getRight();
        }
        
        /*Se sono giunto qua vuol dire che non ho trovato un nodo del albero
        che contiene la chiave da me ricercata, per cui ritorno "Falso"*/
        return false;
    }

    /**
     *
     * @param key
     * 
     */
    @Override
    public void delete(E key)
    {
        root = delete(root, key);
    }
    
    private Node<E> delete(Node<E> node, E key) 
    {
        if(node == null)
        {
            System.err.println("Impossibile elliminare nodo inesistente");
            System.exit(-1);
        }
        
        if(node.getKey().compareTo(key) == 0)
            node= deleteNode(node);
        else if(node.getKey().compareTo(key) > 0)
            node.setLeft(delete(node.getLeft(), key));
        else
            node.setRight(delete(node.getRight(), key));
        
        return node;
    }
    
    private Node<E> deleteNode(Node<E> node)
    {
        //se il nodo è una foglia
        if(node.isLeaf())
            return null;
        //se il nodo ha solo un figlio sinsitro
        if(node.getLeft() != null && node.getRight() == null)
            return node.getLeft();
        //se il nodo ha solo un figlio destro
        else if(node.getRight() != null && node.getLeft() == null)
            return node.getRight();
        
        else
        {
            //trovo il successore
            Node<E> replacementNode = getMinimum(node.getRight());
            Node<E> newRight = deleteLeftMost(node.getRight());
            
            replacementNode.setRight(newRight);
            replacementNode.setLeft(node.getLeft());
            
            return replacementNode;
        }
        
    }
  
    private Node<E> getSuccessor(Node<E> node)
    {
        Node<E> successore= null;
        Node<E> padreSuccessore= null;
        Node<E> nodoPuntato= node.getRight();

        while(nodoPuntato!=null)
        {
                padreSuccessore= successore;
                successore= nodoPuntato;
                nodoPuntato= nodoPuntato.getLeft();
        }
        
        /*controllo se il successore ha un figlio destro(è impossibile che ne
        abbia uno destro essendo lui il piu piccolo del sottoalbero), in caso
        positivo il figlio diventare figlio sinistro del padre del successore*/
        if(successore != node.getRight())
        {
                padreSuccessore.setLeft(successore.getRight());
                successore.setRight(node.getRight());
        }
        
        return successore;
    }
    
    protected Node<E> getMinimum(Node<E> node)
    {
        //ritorna il più piccolo nodo
        if(node.getLeft() == null)
            return node;
        
        return getMinimum(node.getLeft());    
    
    }
    
    private Node<E> deleteLeftMost(Node<E> node)
    {
        if(node.getLeft() == null)
            return node.getRight();
        
        Node<E> newChild = deleteLeftMost(node.getLeft());     
        node.setLeft(newChild);
        
        return node;
    }

    /**
     *
     * @param key
     * @return successor
     */
    public E getSuccessor(E key)
    {
        
        Node<E> nodoPuntato = root;

        while(nodoPuntato != null)
        {

            if(nodoPuntato.getKey().compareTo(key) == 0)
                return getSuccessor(nodoPuntato).getKey();
            
            if(nodoPuntato.getKey().compareTo(key) > 0)
                nodoPuntato = nodoPuntato.getLeft();
            else
                nodoPuntato = nodoPuntato.getRight();
        }
        
        return null;
    }
    
    /**
     *
     * @return minimum value
     */
    public E getMinimum()
    {
        Node<E> n = getMinimum(root);
        return n.getKey();
    }
   
    /**
     *
     * @return maximum value
     */
    public E getMaximum()
    {
        Node<E> n = getMaximum(root);
        return n.getKey();
    }
    
    protected Node<E> getMaximum(Node<E> node)
    {
        if(node.getRight() == null)
            return node;
        
        return getMaximum(node.getRight());
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
    
    @Override
    public DefaultListModel<E> toArray()
    {
        DefaultListModel<E> arr = new DefaultListModel();
        toArray(root, arr);
        return arr;
    }
    
    private void toArray(Node<E> node, DefaultListModel<E> arr)
    {
        if(node == null)
            return;
        toArray(node.getLeft(), arr);
        arr.addElement(node.getKey());
        toArray(node.getRight(), arr);
    }
    
}
