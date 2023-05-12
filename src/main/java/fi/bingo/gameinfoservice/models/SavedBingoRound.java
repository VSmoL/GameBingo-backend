package fi.bingo.gameinfoservice.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class SavedBingoRound {

    @Getter @Setter private List<BingoCoupon> bingoCoupons;
    @Getter @Setter private List<Integer> drawnNumbers;

    public SavedBingoRound(List<BingoCoupon> bingoCoupons, List<Integer> drawnNumbers){
        this.bingoCoupons = bingoCoupons;
        this.drawnNumbers = drawnNumbers;
    }
}
