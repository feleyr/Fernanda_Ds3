package com.alessiojr.demojpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
//INSERT INTO table_item(nome, tipo, quantidade, is_active) VALUES ('livro', 'amor&gelato', '2','1');

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "table_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 64)
    private String nome;
    private String tipo;
    private String quantidade;
    private Boolean isActive;

    public static Item parseNote(String line) {
        String[] text = line.split(",");
        Item note = new Item();
        note.setId(Long.parseLong(text[0]));
        note.setNome(text[1]);
        return note;
    }
}
