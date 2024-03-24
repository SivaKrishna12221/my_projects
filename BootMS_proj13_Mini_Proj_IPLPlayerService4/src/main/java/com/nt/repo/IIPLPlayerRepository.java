package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.IPLPlayer;
@Repository
public interface IIPLPlayerRepository extends JpaRepository<IPLPlayer, Integer> {

}
