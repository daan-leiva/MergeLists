import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)

    {

        MergeList ho = new MergeList("C:\\Users\\dleiva\\Downloads\\file20.txt");

        LinkedList <Item> listJ = new LinkedList <Item>();

        ho.readData(listJ);

        ho.printList(listJ);

        ho.mergeSort(listJ);

        ho.printList(listJ);

    }
}
