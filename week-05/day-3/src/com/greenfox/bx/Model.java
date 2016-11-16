package com.greenfox.bx;

import java.util.Comparator;

/**
 * Created by Rita on 2016-11-16.
 */
public class Model implements Comparable<Model> {
    private String name;
    private String size;
    private int rtV4M;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRtV4M() {
        return rtV4M;
    }

    public void setRtV4M(int rtV4M) {
        this.rtV4M = rtV4M;
    }

    public static Comparator<Model> ModelNameComparator = new Comparator<Model>() {
        public int compare(Model model1, Model model2) {
            String left = model1.getName().toUpperCase();
            String right = model2.getName().toUpperCase();
            return left.compareTo(right);
        }
    };

    public static Comparator<Model> ModelSizeComparator = new Comparator<Model>() {
        public int compare(Model model1, Model model2) {
            String left = model1.getSize().toUpperCase();
            String right = model2.getSize().toUpperCase();
            return left.compareTo(right);
        }
    };

    @Override
    public int compareTo(Model model) {
        return this.getRtV4M() - model.getRtV4M();
    }

    public Model(String name, String size, int rtV4M) {
        this.name = name;
        this.size = size;
        this.rtV4M = rtV4M;
    }

    @Override
    public String toString() {
        return name + " - " + size + " diagonal (" + rtV4M + ")";
    }
}
