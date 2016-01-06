import java.util.*;
import java.io.*;


public class MergeList {
    private Scanner inFile;
    private String myFile;


    public MergeList(String fileName) {
        myFile = fileName;
    }

    public LinkedList<Item> mergeSort(LinkedList<Item> listA) {
        LinkedList<Item> listB = new LinkedList<Item>();

        if (listA == null) {
            return null;
        }
        // Don't sort an empty list or a list with one node
        if (listA.size() <= 1) {
            return listA;
        }


        split(listA, listB);

        return merge(mergeSort(listA), mergeSort(listB));
    }

    public void readData(LinkedList<Item> list) {
        int id;
        int inv;
        Scanner in;
        try {
            in = new Scanner(new File(myFile));
            while (in.hasNext()) {
                id = in.nextInt();
                inv = in.nextInt();
                list.addFirst(new Item(id, inv));
            }

        } catch (IOException i) {
            System.out.println("Error: " + i.getMessage());
        }
    }


    public void printList(LinkedList list) {
        System.out.printf("%5s%16s", "Id", "Inventory\n");
        System.out.println();
        for (int u = 0; u < list.size(); u++) {
            System.out.println(list.get(u).toString());
        }
    }

    /**
     * Splits listA into two parts. listA retains the first
     * half of the list, listB contains the last half of
     * the original list.
     *
     * @param listA Original list. reduced by half after split.
     * @param listB Contains last half of the original list
     */
    public void split(LinkedList<Item> listA, LinkedList<Item> listB) {
        if (listA.size() >= 2) {
            int div = (listA.size()) / 2;

            LinkedList<Item> listC = new LinkedList<Item>();
            LinkedList<Item> listD = new LinkedList<Item>();
            for (int i = 0; i < div; i++) {
                listC.add(listA.get(i));
                listD.add(listA.get(i + div));
            }
            if (listA.size() % 2 != 0)
                listD.addLast(listA.get(listA.size() - 1));
            // clear lists
            listA.clear();
            listB.clear();
            // add new variables
            listA.addAll(listC);
            listB.addAll(listD);
        }
    }

    /**
     * Two linked lists listA and listB are merged into a single
     * linked list mergedList. They are placed in mergedList starting
     * with the smallest item on either list and continue working up to
     * to largest item.
     *
     * @param listA LinkedList in nondecreasing order
     * @param listB LinkedList in nondecreasing order
     * @return List  containing all the values from lists listA
     * and listB, in nondecreasing order
     */
    public LinkedList<Item> merge(LinkedList<Item> listA, LinkedList<Item> listB) {
        // make sure the target list is empty
        LinkedList<Item> mergedList = new LinkedList<Item>();
        int a = 0;
        int b = 0;

        // start at mergedList left and right item
        // continue until either left or right list has no more value to add
        // use <= instead of < so if duplicate take from left so sort is stable
        while (a < listA.size() && b < listB.size()) {
            if (listA.get(a).compareTo(listB.get(b)) >= 0) {
                mergedList.addLast(listA.get(a));
                a++;
            } else {
                mergedList.addLast(listB.get(b));
                b++;
            }
        }
        if (a < listA.size()) {
            for (int i = a; i < listA.size(); i++) {
                mergedList.addLast(listA.get(i));
            }
        } else {
            for (int j = b; j < listB.size(); j++) {
                mergedList.addLast(listB.get(j));
            }

        }

        // One of the next two while loops will execute.  It will be the one with some values
        // left on the list.

        return mergedList;
    }

    /**
     * Reverses the order of a list
     *
     * @param list LinkedList to be reversed
     * @return List in reverse order
     */
    public LinkedList<Item> reverseList(LinkedList<Item> list) {
        LinkedList<Item> listC = new LinkedList<Item>();
        for (int r = 0; r < list.size(); r++)
            listC.addFirst(list.get(r));
        list = listC;
        return listC;
    }
}
