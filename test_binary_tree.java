package Laba4;

public class test_binary_tree {
    public static void main(String[] argv){

        // Вызываем
        binary_tree<Integer> tree = new binary_tree<>();
        // Добовляем
        tree.add(50, tree.getHead());
        tree.add(49, tree.getHead());
        tree.add(3, tree.getHead());
        tree.add(55, tree.getHead());
        tree.add(1, tree.getHead());
        tree.add(46, tree.getHead());
        tree.add(60, tree.getHead());
        tree.add(50, tree.getHead());
        tree.add(3, tree.getHead());

        // Выводим дерево
        tree.printTree();
        // Число элементов в дереве
        System.out.println(tree.getCount());
        // Поиск элемента
        Node<Integer> node = new Node<>();
        node = tree.findNodeByValue(46);
        System.out.println(node.getData());
        // удаление
        tree.deleteTree();
        System.out.println(tree.getCount());

    }
    
}
