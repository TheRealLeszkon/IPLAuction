package com.Michael.projects.IPLAuction.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "cricketers")

public class Batsman {
    @Id
    private Integer pos;
    private String player;
    private Integer runs;
    private Integer mat;
    private Integer inns;
    private Integer notout;
    private String hs;
    private BigDecimal average;
    private Integer bf;
    private BigDecimal sr;
    private Integer centuries;
    private Integer half_centuries;
    private Integer fours;
    private Integer sixes;

    public Integer getPos() {
        return pos;
    }

    public String getPlayer() {
        return player;
    }

    public Integer getRuns() {
        return runs;
    }

    public Integer getMat() {
        return mat;
    }

    public Integer getInns() {
        return inns;
    }

    public Integer getNotout() {
        return notout;
    }

    public String getHs() {
        return hs;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public Integer getBf() {
        return bf;
    }

    public BigDecimal getSr() {
        return sr;
    }

    public Integer getCenturies() {
        return centuries;
    }

    public Integer getHalf_centuries() {
        return half_centuries;
    }

    public Integer getFours() {
        return fours;
    }

    public Integer getSixes() {
        return sixes;
    }
}
