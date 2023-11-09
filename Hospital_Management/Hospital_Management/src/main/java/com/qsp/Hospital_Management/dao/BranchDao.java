package com.qsp.Hospital_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo repo;

	public Branch saveBranch(Branch branch) {

		return repo.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	public Branch deleteBranch(int id) {
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Branch updateBranch(Branch branch, int id) {
		Optional<Branch> optional = repo.findById(id);
		if (optional.isPresent()) {
			branch.setId(id);
			{

				return repo.save(branch);
			}
		}
		return null;
	}

}
