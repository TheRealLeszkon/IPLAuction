package com.Michael.IPLAuctionDashboard.repositories;

import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllRounderRepository extends JpaRepository<AllRounder,Integer> {
}
