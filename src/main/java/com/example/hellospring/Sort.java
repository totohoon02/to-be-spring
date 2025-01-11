package com.example.hellospring;

import java.util.List;

public class Sort {
    public List<String> sortByLength(List<String> list) {
        list.sort((l1, l2) -> l1.length() - l2.length());
        return list;
    }
}
