package fi.bingo.gameinfoservice.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BingoCoupon {
    
    @Getter @Setter private List<Integer> bingoBumbers;
    @Getter @Setter private Game game;

    public BingoCoupon(List<Integer> bingoNumbers, Game game){
        this.bingoBumbers = bingoNumbers;
        this.game = game;
    }
}
