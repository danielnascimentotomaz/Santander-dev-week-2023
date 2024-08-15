package me.dio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;

    public User(String nome) {
        this.nome = nome;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;


    //@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //A propriedade mappedBy é usada em mapeamentos de relacionamento bidirecional no JPA (Java Persistence API) para indicar qual entidade é responsável pelo relacionamento e para evitar a criação de tabelas intermediárias desnecessárias.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Featuare> featuares;

      //@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     //A propriedade mappedBy é usada em mapeamentos de relacionamento bidirecional no JPA (Java Persistence API) para indicar qual entidade é responsável pelo relacionamento e para evitar a criação de tabelas intermediárias desnecessárias.
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private List<News> news;


}
