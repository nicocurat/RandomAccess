import java.io.Serializable;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class BinarySearchTree<T> implements Serializable{

    private DoubleNode<T> raiz;

    public BinarySearchTree() {
        raiz = null;
    }

    /**
     * elemento a insertar no pertenece al árbol
     */

    public void insertar(Comparable<T> x) {
        if(!existe(x)){
            raiz = insertar(raiz, x);
        } else{
            throw new RuntimeException("The element is already in the tree");
        }
    }

    /**
     * elemento a eliminar pertenece al árbol
     */

    public void eliminar(Comparable<T> x) {
        if(existe(x)) {
            raiz = eliminar(raiz, x);
        } else {
            throw new RuntimeException("The element is not in the tree");
        }
    }

    /**
     * árbol distinto de vacío
     * @return Element
     */

    public T getMin() {
        if(esVacio()){
            throw new RuntimeException("The tree is empty");
        }
        return getMin(raiz).element;
    }

    /**
     * árbol distinto de vacío
     */

    public T getMax() {
        if(esVacio()){
            throw new RuntimeException("The tree is empty");
        }
        return getMax(raiz).element;
    }

    /**
     * elemnto a buscar pertenece al arbol
     */

    public T buscar(Comparable<T> x) {
        if(!existe(x)){
            throw new RuntimeException("The element is not in the tree");
        }
        return buscar(raiz, x).element;
    }


    public boolean existe(Comparable<T> x) {
        return existe(raiz, x);
    }


    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * árbol distino de vacío
     * @return Element
     */

    public T getRaiz() {
        if(esVacio()){
            throw new RuntimeException("The tree is empty");
        }
        return raiz.element;
    }

    /**
     * árbol distino de vacío
     * @return Binary Search Tree
     */
    public BinarySearchTree<T> hijoIzq() {
        BinarySearchTree t = new BinarySearchTree();
        t.raiz = raiz.left;
        return t;
    }

    /**
     * árbol distino de vacío
     * @return Binary Search Tree
     */

    public BinarySearchTree<T> hijoDer() {
        BinarySearchTree t = new BinarySearchTree();
        t.raiz = raiz.right;
        return t;
    }


    private DoubleNode<T> getMax(DoubleNode<T> t) {
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    private DoubleNode<T> getMin(DoubleNode<T> t) {
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNode<T> buscar(DoubleNode<T> t, Comparable<T> x) {
        if (x.compareTo(t.element) == 0)
            return t;
        else if (x.compareTo(t.element) < 0)
            return buscar(t.left, x);
        else
            return buscar(t.right, x);
    }

    private boolean existe(DoubleNode<T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.element) == 0)
            return true;
        else if (x.compareTo(t.element) < 0)
            return existe(t.left, x);
        else
            return existe(t.right, x);
    }

    private DoubleNode<T> insertar(DoubleNode t, Comparable x) {
        if (t == null) {
            t = new DoubleNode<>(x);
            t.element = x;
        } else if (x.compareTo(t.element) < 0)
            t.left = insertar(t.left, x);
        else
            t.right = insertar(t.right, x);
        return t;
    }

    private DoubleNode<T> eliminar(DoubleNode<T> t, Comparable x) {
        if (x.compareTo(t.element) < 0)
            t.left = eliminar(t.left, x);
        else if (x.compareTo(t.element) > 0)
            t.right = eliminar(t.right, x);
        else if (t.left != null && t.right != null) {
            t.element = getMin(t.right).element;
            t.right = eliminarMin(t.right);
        } else if (t.left != null) t = t.left;
        else
            t = t.right;
        return t;
    }

    private DoubleNode<T> eliminarMin(DoubleNode<T> t) {
        if (t.left != null)
            t.left = eliminarMin(t.left);
        else
            t = t.right;
        return t;
    }
}
