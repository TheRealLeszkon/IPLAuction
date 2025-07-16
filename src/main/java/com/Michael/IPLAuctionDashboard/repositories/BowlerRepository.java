package com.Michael.IPLAuctionDashboard.repositories;

import com.Michael.IPLAuctionDashboard.domains.entities.Bowler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlerRepository extends JpaRepository<Bowler,Integer> {
}
