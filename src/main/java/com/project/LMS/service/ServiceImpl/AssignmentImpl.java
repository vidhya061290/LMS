package com.project.LMS.service.ServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.AssignmentRepository;
import com.project.LMS.Dto.AssignmentDto;
import com.project.LMS.mapper.AssignmentMapper;
import com.project.LMS.models.Assignment;
import com.project.LMS.service.AssignmentService;

@Service
public class AssignmentImpl implements AssignmentService{
@Autowired
AssignmentRepository aRepo;
@Autowired
AssignmentMapper aMapper;
	@Override
	public ResponseEntity<AssignmentDto> addAssignment(AssignmentDto ad) {
		Assignment a = aMapper.mapToAssignment(ad);
		Assignment a1 = aRepo.save(a);
		AssignmentDto adto = aMapper.mapToAssignmentDto(a1);
		return new ResponseEntity<> (adto , HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<AssignmentDto> getById(int id) {
		Optional<Assignment> a = aRepo.findById(id);
		AssignmentDto adto = aMapper.mapToAssignmentDto(a.get());
		return new ResponseEntity<>(adto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<AssignmentDto>> getAllAssignment() {
		List<Assignment> assignment = aRepo.findAll();
		List<AssignmentDto> adto = new ArrayList<>();
		for(Assignment a : assignment) {
			AssignmentDto ad = aMapper.mapToAssignmentDto(a);
			adto.add(ad);
		}
		return new ResponseEntity<>(adto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AssignmentDto> updateById(int id, AssignmentDto ad) {
	Optional<Assignment> a = aRepo.findById(id);
	a.get().setCourseId(ad.getCourseId());
	a.get().setCreatedAt(ad.getCreatedAt());
	a.get().setDescription(ad.getDescription());
	a.get().setDueAt(ad.getDueAt());
	a.get().setTitle(ad.getTitle());
	Assignment aa = aRepo.save(a.get());
	AssignmentDto adto = aMapper.mapToAssignmentDto(aa);
	return new ResponseEntity<> (adto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AssignmentDto> updateTitleById(int id, String title) {
		Optional<Assignment> a = aRepo.findById(id);
		a.get().setTitle(title);
		Assignment aa = aRepo.save(a.get());
		AssignmentDto adto = aMapper.mapToAssignmentDto(aa);
		return new ResponseEntity<> (adto , HttpStatus.OK);
		}

	@Override
	public ResponseEntity<AssignmentDto> updateDescriptionById(int id, String description) {
		Optional<Assignment> a = aRepo.findById(id);
		a.get().setTitle(description);
		Assignment aa = aRepo.save(a.get());
		AssignmentDto adto = aMapper.mapToAssignmentDto(aa);
		return new ResponseEntity<> (adto , HttpStatus.OK);
		}

	@Override
	public ResponseEntity<AssignmentDto> updateDueAtById(int id, Timestamp dueAt) {
		Optional<Assignment> a = aRepo.findById(id);
		a.get().setDueAt(dueAt);
		Assignment aa = aRepo.save(a.get());
		AssignmentDto adto = aMapper.mapToAssignmentDto(aa);
		return new ResponseEntity<> (adto , HttpStatus.OK);
		
	}

}
