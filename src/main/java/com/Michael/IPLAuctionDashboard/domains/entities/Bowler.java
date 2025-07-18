package com.Michael.IPLAuctionDashboard.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bowlers")
public class Bowler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "association")
    private String association;
    @Column(name = "price",precision = 15,scale = 2)
    private BigDecimal price;
    @Column(name = "image_links")
    private String imageLink;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PlayerStatus playerStatus;
    @Column(name = "sold_price",precision = 15,scale = 2)
    private BigDecimal soldPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    //stats
    @Column(name = "wickets")
    private Integer wickets;
    @Column(name = "matches")
    private Integer matches;
    @Column(name = "economy",precision = 6,scale = 2)
    private BigDecimal economy;
    @Column(name = "best_figure",precision = 6,scale = 2)
    private String bestFigure;
}
