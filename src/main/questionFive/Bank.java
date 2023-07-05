package main.questionFive;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    int id;
    Bank parent;
    List<Bank> children;

    public Bank(int id) {
        this.id = id;
        this.parent = null;
        this.children = new ArrayList<>();
    }
}
