package com.example.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Voting.*;

public interface VRepository extends JpaRepository<Voting,Integer> {

	Optional<Voting> findByName(String name);


	   @Query("SELECT COUNT(vote) FROM Voting vote")
	    int countAllVotes();
	   
	   
	   @Query("SELECT COUNT(vott) FROM Voting vott WHERE vott.vote = :voteValue")
	    int countAllVoting(@Param("voteValue") int voteValue);



}
