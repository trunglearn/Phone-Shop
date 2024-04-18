/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.TreeMap;
/**
 *
 * @author ACERR
 */
public class Compares {

    private TreeMap<Product, Integer> listcompare;
    private long compareID;

    public Compares() {
        listcompare = new TreeMap<>();
        compareID = System.currentTimeMillis();
    }

    public Compares(TreeMap<Product, Integer> listcompare, long compareID) {
        this.listcompare = listcompare;
        this.compareID = compareID;
    }

    public TreeMap<Product, Integer> getListcompare() {
        return listcompare;
    }

    public void setListcompare(TreeMap<Product, Integer> listcompare) {
        this.listcompare = listcompare;
    }

    public long getCompareID() {
        return compareID;
    }

    public void setCompareID(long compareID) {
        this.compareID = compareID;
    }

    public void addToCompare(Product sp) {
        listcompare.put(sp, 1);
    }

    public void removeToCompare(Product sp) {
        boolean bln = listcompare.containsKey(sp);
        if (bln) {
            listcompare.remove(sp);

        }
    }

}

