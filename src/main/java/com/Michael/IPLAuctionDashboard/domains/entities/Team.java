package com.Michael.IPLAuctionDashboard.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "balance")
    private BigDecimal balance;
    @OneToMany(mappedBy = "team")
    private List<Batsman> batsmenList;
    @OneToMany(mappedBy = "team")
    private List<Bowler> bowlerList;
    @OneToMany(mappedBy = "team")
    private List<AllRounder> allRoundersList;

}
