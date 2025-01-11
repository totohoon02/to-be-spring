package com.example.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SortTest {
    Sort sort;

    @BeforeEach
    void setUp() {
        sort = new Sort();
    }

    @Test
    void sort(){
        // given
        // when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        // then
        assertThat(list).isEqualTo(List.of("b", "aa"));
    }
}
