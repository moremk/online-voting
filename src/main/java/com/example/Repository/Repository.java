package com.example.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Voting.*;
public interface Repository extends JpaRepository<Vote,Integer> {

	

	Vote findByName(String string);

}
