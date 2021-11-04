package com.alan.test.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private int age;
    private String name;
    private List<Integer> id;
}
