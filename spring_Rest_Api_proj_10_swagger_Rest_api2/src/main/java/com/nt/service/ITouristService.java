package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> getAllTousrist();
	public Tourist getById(Integer id);
	public String UpdateTourist(Tourist tourist);
	public String deleteByTourist(Integer id);
	public String partialUpdateTourist(Integer id,double hikePercenetage);
}
