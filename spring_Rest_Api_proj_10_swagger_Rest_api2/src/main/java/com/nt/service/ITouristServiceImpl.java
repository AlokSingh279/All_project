package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repository.ITouristRepository;

@Service
public class ITouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristRepository touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int id = touristRepo.save(tourist).getTid();
		return "Tourist data will be saved" + id;
	}

	@Override
	public List<Tourist> getAllTousrist() {
		return touristRepo.findAll();
	}

	@Override
	public Tourist getById(Integer id) {
		return touristRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Integer id is not found"));
	}

	@Override
	public String UpdateTourist(Tourist tourist) {
		Optional<Tourist> opt = touristRepo.findById(tourist.getTid());
		if (opt.isPresent()) {
			touristRepo.save(tourist);
			return "tourist details are updated";
		}
		return "tourist is not found for updation";
	}

	@Override
	public String deleteByTourist(Integer id) {
		Optional<Tourist> opt = touristRepo.findById(id);
		if (opt.isPresent()) {
			touristRepo.deleteById(id);
			return "Tourist id is deleted";
		}
		return "Tourist id is not found";
	}

	@Override
	public String partialUpdateTourist(Integer id, double hikePercenetage) {

		Optional<Tourist> opt = touristRepo.findById(id);
		if (opt.isPresent()) {
			Tourist tourist = opt.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * hikePercenetage / 100.0f));
			touristRepo.save(tourist);
			return id + "Tourist budget is hiked by" + tourist.getBudget();
		}
		return id + "Tourist is not found for updation";
	}

}
