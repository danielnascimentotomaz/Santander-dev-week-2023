package me.dio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  Long id;
    private String nome;

    private Account account;

    private List<Featuare> featuares;

    private List<News> news;


}
