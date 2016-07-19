package Random;

import java.io.Serializable;

/**
 * Created by brunodeluca on 7/18/16.
 */
public class DoubleNode<T> implements Serializable{
    T element;
    DoubleNode<T> left, right;

    public DoubleNode(T o){
        element = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right){
        element = o;
        this.left = left;
        this.right = right;
    }
}