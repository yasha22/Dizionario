
package dizionario_albero_stringhe;

import javax.swing.DefaultListModel;

public interface BST<E>
{

    public void insert(E key);
    public boolean find(E key);
    public void delete(E key);
    public DefaultListModel<E> toArray();
  
}
