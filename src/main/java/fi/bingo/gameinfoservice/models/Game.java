package fi.bingo.gameinfoservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(nullable = false, unique = true)
    @Getter @Setter private String name;

    public Game(){
        super();
    }

    public Game(Integer id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}
