package edu.gcccd.csis;


public class GenericQueue<T> {

    public class Node<T> {

        T data;
        Node<T> nextNode;

        Node(T object) {

            this(object, null);
        }

        Node(T object, Node<T> node) {

            data = object;
            nextNode = node;
        }

    }

    public class List <T> {

        private Node<T> firstNode;
        private Node<T> lastNode;
        private String name;
        private int size;

        public List()
        {
            this("list");
        }

        public List(String listName) {

            name = listName;
            firstNode = lastNode = null;
            size = 0;
        }


        // insert item at end of list
        public void insert(T insertItem){
            if (isEmpty()) // firstNode and lastNode refer to same object
                firstNode = lastNode = new Node<T>(insertItem);
            else // lastNode's nextNode refers to new node
                lastNode.nextNode = new Node<T>(insertItem);
            size++;
        }

        // remove first node from List
        public T remove() throws EmptyListException
        {
            if(isEmpty()) // throw exception if LIst is empty
                throw new EmptyListException(name);

            T removedItem = firstNode.data;

            // update references firstNode and lastNode
            if (firstNode == lastNode)
                firstNode = lastNode = null;
            else
                firstNode = firstNode.nextNode;
            size--;
            return removedItem;
        }

        public boolean isEmpty()
        {
            return firstNode == null; // return true if list is empty
        }

    }




    private List<T> queueList;

    public GenericQueue() {

        queueList = new List<T>("queue");
    }

    public T dequeue() throws EmptyListException
    {
      return queueList.remove();
    }

    public void enqueue(T obj)
    {
        queueList.insert(obj);
    }

    // current length of the queue
    public int length()
    {
        return queueList.size;
    }

        }
