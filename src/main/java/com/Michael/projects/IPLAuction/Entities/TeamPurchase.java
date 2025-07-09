package com.Michael.projects.IPLAuction.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team_purchases")
public class TeamPurchase {
    @Id
    private Integer p_id;
    private String p_name;
    private Integer team_id;
    private String team_name;
}
