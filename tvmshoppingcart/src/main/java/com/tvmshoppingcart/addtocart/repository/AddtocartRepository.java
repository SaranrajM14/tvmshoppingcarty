package com.tvmshoppingcart.addtocart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvmshoppingcart.addtocart.model.Addtocart;
@Repository
public interface AddtocartRepository extends JpaRepository < Addtocart, Long > {
	List<Addtocart> findMovieByUserid(long userid);
}
