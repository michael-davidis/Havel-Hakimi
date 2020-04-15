/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michalDavidis.HavelHakimiAlgorithm.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 *
 * @author Mike
 */
public class Main {

    /**
     * Removes zeros from given ArrayList
     *
     * @param numList ArrayList to be used
     * @return ArrayList without zeros
     */
    public static ArrayList<Integer> removeZeros(ArrayList<Integer> numList) {
        return numList.stream().filter(x -> !x.equals(0)).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Sorts an ArrayList in descending order
     *
     * @param numList ArrayList to be sorted
     */
    public static void reverseSorting(ArrayList<Integer> numList) {
        Collections.sort(numList, Collections.reverseOrder());
    }

    /**
     * Subtracts one from the ArrayList's positions indicated by a given integer
     *
     * @param firstItem The indicator integer
     * @param numList ArrayList to be used
     * @return ArrayList with first items subtracted by one
     */
    public static ArrayList<Integer> subtractFromNFirstPositions(int firstItem, ArrayList<Integer> numList) {
        for (int i = 0; i < firstItem; i++) {
            numList.set(i, numList.get(i) - 1);
        }

        return numList;
    }

    /**
     * Checks whether the give Array conforms with the Havel-Hakimi logic. If
     * the ArrayList is empty, then it conforms with this logic. Else we need to
     * remove the largest item of the list (n) and check it it is larger than the
     * size of the list. If it is, then the ArrayList is false. If it is not, we
     * subtract one from each of the first items of the this, which is indicated
     * be the value of the removed item.
     *
     * @param numList ArrayList to be checked
     * @return Boolean of whether the ArrayList conforms or not.
     */
    public static boolean checkArray(ArrayList<Integer> numList) {
//      Removing zeros form list
        numList = removeZeros(numList);
//      Reversing the order of the list
        reverseSorting(numList);
        boolean checkCond = true;
//      Checking if the list is empty
        while (!numList.isEmpty()) {
//          Removing the first item, which is the largest
            int n = numList.remove(0);
//          If the removed number is bigger than the list's size, it changed the boolean to false
            if (n > numList.size()) {
                checkCond = false;
                break;
            } else {
//              Subtracting one from the first n positions
                subtractFromNFirstPositions(n, numList);
//              Removing zeros form list
                numList = removeZeros(numList);
//              Reversing the order of the list
                reverseSorting(numList);
            }
        }

        return checkCond;
    }

    public static void main(String[] args) {
        ArrayList<Integer> witnessTestimony = new ArrayList<>(Arrays.asList(5, 3, 0, 2, 6, 2, 0, 7, 2, 5));
        System.out.println("The witnesses' testimony is " + checkArray(witnessTestimony) + ".");
    }

}
