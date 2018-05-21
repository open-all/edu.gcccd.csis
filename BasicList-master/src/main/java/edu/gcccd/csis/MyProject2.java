package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;

public class MyProject2 implements Project2 {

    @Override
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
        NodeList<Integer> result = new NodeList<>();
        nodeList1 = reverse(nodeList1.iterator());
        nodeList2 = reverse(nodeList2.iterator());
        Iterator<Integer> iter1 = nodeList1.iterator();
        Iterator<Integer> iter2 = nodeList2.iterator();
        int carry = 0, sum;

        while(iter1.hasNext() || iter2.hasNext()) {

            sum = carry + (iter1.hasNext() ? iter1.next() : 0) + (iter2.hasNext() ? iter2.next(): 0);
            // update carry
            carry = (sum >= 10) ? 1 : 0;
            // update sum if it is greater than 10
            sum = sum % 10;
            //set the head of the result list nodeList
            result.append(sum);
        }

        if (carry > 0)
            result.append(carry);

        result = reverse(result.iterator());

        while(result.iterator().next().equals(0) && result.getLength() > 1 && result.iterator().hasNext()) {
            result.remove(0);
        }

        return result; }

    @Override
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> listOfLists) {

        NodeList<Integer> resultOfLists = (listOfLists.hasNext() ? listOfLists.next() : new NodeList<>());

        while(listOfLists.hasNext()) {
            resultOfLists = addition(resultOfLists, listOfLists.next());
        }



        return resultOfLists;
    }

    @Override
    public void save(NodeList<Integer> nodeList, String fileName) {

        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));

            for(Integer integer : nodeList){

                outputStream.write(integer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public NodeList<Integer> load(String fileName) {

        NodeList<Integer> list = new NodeList<>();

        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));

            while (0 < inputStream.available()){

                list.append(inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioexception ) {
            ioexception.printStackTrace();
        }

        return list;
    }


    public NodeList<Integer> reverse(Iterator<Integer> iter)
    {
        NodeList<Integer> nl;
        if (iter.hasNext())
        {
            Integer t = iter.next();
            nl = reverse(iter);
            nl.append(t);
        }
        else
            nl = new NodeList<>();
        return nl;
    }


    public static void main(final String[] args) {
        final int L = 30;

        final NodeList<Integer> n1 = Project2.generateNumber(L); // (head 1st) e.g. 3457
        final NodeList<Integer> n2 = Project2.generateNumber(L); // (head 1st) e.g. 682

        MyProject2 myProject2 = new MyProject2();


        final Project2 p = new MyProject2();

        Project2.print(p.addition(n1, n2)); //  n1+n2, e.g. 4139

        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < L; i++) {
            listOfLists.append(Project2.generateNumber(L));
        }
        p.save(p.addition(listOfLists.iterator()), "result.bin");
        Project2.print(p.load("result.bin"));
    }

}
