package Laba4;
import java.util.Stack;


class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    private T data;
    private Node<T> left;
    private Node<T> right;

    // Удаление всех элементов
    public void setData()
    {
        this.data = null;
    }
    public void setLeft()
    {
        this.left = null;
    }
    public void setRight()
    {
        this.right = null;
    }

    //Конструктор
    public void setData(T data)
    {
        this.data = data;
    }
    public void setLeft(Node<T> left)
    {
        this.left = left;
    }
    public void setRight(Node<T> right)
    {
        this.right = right;
    }
    public T getData()
    {
        return this.data;
    }
    public Node<T> getLeft()
    {
        return this.left;
    }
    public Node<T> getRight()
    {
        return this.right;
    }
    Node(T data)
    {
        this.setData(data);
        this.setLeft();
        this.setRight();
    }
    Node()
    {
        this.setData();
        this.setLeft();
        this.setRight();
    }

    public int compareTo(Node<T> another) {
        return data.compareTo(another.data);
    }


}

public class binary_tree<T extends Comparable<T>> {
    private Node<T> head;
    private int count;

    // конструктор 
    binary_tree() {
        this.head = null;
        this.count = 0;
    }

    //копирование
    binary_tree<T> treeCopy(binary_tree<T> data) {
        return data;
    }
    
    public void setCount()
    {
        this.count = 0;
    }
    public void setHead()
    {
        this.head = null;
    }
    public void setCount(int a)
    {
        if (a == 1)
            this.count++;
    }
    public void setHead(Node<T> head)
    {
        this.head = head;
    }
    public int getCount()
    {
        return this.count;
    }
    public Node<T> getHead()
    {
        return this.head;
    }

    // метод для вывода дерева в консоль
    public void printTree() { 
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(this.getHead());
        int gaps = 64; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева

        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // пока в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getData()); // выводим его значение в консоли
                    localStack.push(temp.getLeft()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }

    
    // добавление элемента 
    void add(T data, Node<T> first)
    {
        Node<T> temp = new Node<>(data);
        if (this.getHead() == null) {
            this.setHead(temp);
            this.setCount(1);
        } else {
            Node<T> X = first;
            if (X.compareTo(temp) > 0 && X.getLeft() != null) {
                X = X.getLeft();
                this.add(data, X);
            }
            else if(X.compareTo(temp) > 0 && X.getLeft() == null){
                X.setLeft(temp);
                this.setCount(1);
            }
            else if(X.compareTo(temp) <= 0 && X.getRight() != null){
                X = X.getRight();
                this.add(data, X);
            }
            else if(X.compareTo(temp) <= 0 && X.getRight() == null){
                X.setRight(temp);
                this.setCount(1);
            }
            else
                System.out.println("Данные не были добавлены");
        }
    }


    // поиск элемента в узалах, если находит то он его выводит
    public Node<T> findNodeByValue(T value) { 
        Node currentNode = head; // начинаем поиск с корневого узла
        Node<T> searchNode = new Node<>(value);
        while (currentNode.getData() != value) { // поиск пока не будет найден элемент или не будут перебраны все
            if (currentNode.compareTo(searchNode) > 0) { // движение влево
                currentNode = currentNode.getLeft();
            } else if (currentNode.compareTo(searchNode) < 0) { // движение вправо
                currentNode = currentNode.getRight();
            } else if (currentNode.compareTo(searchNode) == 0)
                return currentNode;
        }
        return currentNode; // возвращаем найденный элемент
    }
    
    // Удаление 
    public void deleteTree()
    {
        this.setHead();
        this.setCount();
    }
    
}