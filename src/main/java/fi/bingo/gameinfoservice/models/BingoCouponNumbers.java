package fi.bingo.gameinfoservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class BingoCouponNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;
    
    @ManyToOne
    @Getter @Setter private BingoCoupon BingoCouponId;

    @Column(nullable = false)
    @Getter @Setter private Integer bingoNumber;
}
