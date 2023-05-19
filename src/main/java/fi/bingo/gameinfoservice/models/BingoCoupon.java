package fi.bingo.gameinfoservice.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class BingoCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @ManyToOne
    @Getter @Setter private Game game;

    @OneToMany
    @Getter @Setter private List<BingoCouponNumbers> bingoCouponNumbers;

    public BingoCoupon(){
        super();
    }

    public BingoCoupon(Integer id, Game game, List<BingoCouponNumbers> bingoCouponNumbers){
    // public BingoCoupon(Integer id, Game game){
        super();
        this.id = id;
        this.game = game;
        this.bingoCouponNumbers = bingoCouponNumbers;
    }
}
