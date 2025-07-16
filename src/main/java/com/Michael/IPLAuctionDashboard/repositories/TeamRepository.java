package com.Michael.IPLAuctionDashboard.repositories;

import com.Michael.IPLAuctionDashboard.domains.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
