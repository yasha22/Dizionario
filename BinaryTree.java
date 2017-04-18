package dizionario_albero_stringhe;

/**
 *
 * @author Yasser
 * @param <E>
 */
public interface BinaryTree<E> 
{
   
    public E root() throws TreeExeption;
    public BinaryTree leftSubTree() throws TreeExeption;
    public BinaryTree rightSubTree() throws TreeExeption;
    public int count();
    public int height();
    public void visitPre();
    public void visitIn();
    public void visitPost();
    public boolean isEmpty();
    public boolean isPresent(E key);
    public boolean isBST(); 
    public boolean isBalanced(); 
    public boolean isComplete(); 
    public boolean isLinkedList();   
    @Override
    public String toString();
    
}
