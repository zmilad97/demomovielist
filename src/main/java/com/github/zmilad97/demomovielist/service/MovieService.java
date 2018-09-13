package com.github.zmilad97.demomovielist.service;

import com.github.zmilad97.demomovielist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieService extends JpaRepository <Movie,Integer>{

}
