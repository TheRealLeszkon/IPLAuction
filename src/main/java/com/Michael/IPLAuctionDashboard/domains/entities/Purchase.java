package com.Michael.IPLAuctionDashboard.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Integer id;
    @Column(name = "team_id")
    private Integer teamId;
    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "sold_price",precision = 15,scale = 2)
    private BigDecimal soldPrice;
    @Column(name = "player_type")
    private String playerType;
}
