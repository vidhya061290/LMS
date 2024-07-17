package com.project.LMS.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.LMS.Dao.ClassroomRepository;
import com.project.LMS.Dto.ClassroomDto;
import com.project.LMS.mapper.ClassroomMapper;
import com.project.LMS.models.Classroom;
import com.project.LMS.service.ClassroomService;

@Service
public class ClassroomImpl implements ClassroomService{
@Autowired
ClassroomRepository cRepo;
@Autowired
ClassroomMapper cMapper;
	@Override
	public ResponseEntity<ClassroomDto> addClassroom(ClassroomDto cDto) {
		Classroom c = cMapper.mapToClassroom(cDto);
		Classroom c1 = cRepo.save(c);
		ClassroomDto cDto1 = cMapper.mapToClassroomDto(c1);
		return new ResponseEntity <>(cDto1 , HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ClassroomDto> getById(int id) {
		Optional <Classroom> c = cRepo.findById(id);
		ClassroomDto cDto = cMapper.mapToClassroomDto(c.get());
		return new ResponseEntity<>(cDto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ClassroomDto>> getAllClassroom() {
		List<Classroom> classrooms = cRepo.findAll();
		List<ClassroomDto> classroomDtos = new ArrayList<>();
		for(Classroom classroom : classrooms) {
			ClassroomDto classroomDto1 = cMapper.mapToClassroomDto(classroom);
			classroomDtos.add(classroomDto1);
		}
		return new ResponseEntity<>(classroomDtos , HttpStatus.OK);
	}
		
	@Override
	public ResponseEntity<ClassroomDto> updateCapacityById(int id, int capacity) {
		Optional<Classroom>classroom = cRepo.findById(id);
		classroom.get().setCapacity(capacity);
		Classroom classroom1 = cRepo.save(classroom.get());
		ClassroomDto cDto = cMapper.mapToClassroomDto(classroom1);
		return new ResponseEntity<>(cDto , HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<ClassroomDto> updateById(int id, ClassroomDto cdto) {
		Optional<Classroom> c = cRepo.findById(id);
		Classroom c1 = cMapper.mapToClassroom(cdto);
		c.get().setId(c1.getId());
		c.get().setClassroomName(c1.getClassroomName());
		c.get().setCapacity(c1.getCapacity());
		c.get().setCreatedAt(c1.getCreatedAt());
	    Classroom c2= cRepo.save(c.get());
		ClassroomDto cdto1 = cMapper.mapToClassroomDto(c2);
		return new ResponseEntity<>(cdto1 , HttpStatus.OK);
		
	}
	@Override
	public ResponseEntity<ClassroomDto> updateClassroomNameById(int id, String classroomName) {
		Optional<Classroom>classroom = cRepo.findById(id);
		classroom.get().setClassroomName(classroomName);
		Classroom classroom1 = cRepo.save(classroom.get());
		ClassroomDto cDto = cMapper.mapToClassroomDto(classroom1);
		return new ResponseEntity<>(cDto , HttpStatus.OK);
	}

}
