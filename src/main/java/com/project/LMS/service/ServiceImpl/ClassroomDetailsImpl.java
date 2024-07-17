package com.project.LMS.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.LMS.Dao.ClassroomDetailsRepository;
import com.project.LMS.Dto.ClassroomDetailsDto;
import com.project.LMS.mapper.ClassroomDetailsMapper;
import com.project.LMS.models.ClassroomDetails;
import com.project.LMS.service.ClassroomDetailsService;

@Service
public class ClassroomDetailsImpl implements ClassroomDetailsService {
@Autowired
ClassroomDetailsRepository cdRepo;
@Autowired
ClassroomDetailsMapper cdMapper;
	@Override
	public ResponseEntity<ClassroomDetailsDto> addClassroomDetails(ClassroomDetailsDto cdDto) {
		ClassroomDetails cd = cdMapper.mapToClassroomDetails(cdDto);
		ClassroomDetails cd1 = cdRepo.save(cd);
		ClassroomDetailsDto cdDto1 = cdMapper.mapToClassroomDetailsDto(cd1);
		return new ResponseEntity <>(cdDto1 , HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<ClassroomDetailsDto> getById(int id) {
		Optional <ClassroomDetails> cd = cdRepo.findById(id);
		ClassroomDetailsDto cdDto = cdMapper.mapToClassroomDetailsDto(cd.get());
		return new ResponseEntity<>(cdDto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ClassroomDetailsDto>> getAllClassroomDetails() {
		List<ClassroomDetails> cds = cdRepo.findAll();
		List<ClassroomDetailsDto> cdDtos = new ArrayList<>();
		for(ClassroomDetails cd : cds) {
			ClassroomDetailsDto cdDto1 = cdMapper.mapToClassroomDetailsDto(cd);
			cdDtos.add(cdDto1);
		}
		return new ResponseEntity<>(cdDtos , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClassroomDetailsDto> updateCourseIdById(int id, int courseId) {
		Optional<ClassroomDetails> cd = cdRepo.findById(id);
		cd.get().setCourseId(courseId);
		ClassroomDetails cd1 = cdRepo.save(cd.get());
		ClassroomDetailsDto cdDto =cdMapper.mapToClassroomDetailsDto(cd1);
		return new ResponseEntity <>(cdDto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClassroomDetailsDto> updateTeacherIdById(int id, int teacherId) {
		Optional<ClassroomDetails>cd = cdRepo.findById(id);
		cd.get().setTeacherId(teacherId);
		ClassroomDetails cd1 = cdRepo.save(cd.get());
		ClassroomDetailsDto cdDto = cdMapper.mapToClassroomDetailsDto(cd1);
		return new ResponseEntity <>(cdDto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClassroomDetailsDto> updateStudentIdById(int id, int studentId) {
		Optional<ClassroomDetails>cd = cdRepo.findById(id);
		cd.get().setStudentId(studentId);
		ClassroomDetails cd1 = cdRepo.save(cd.get());
		ClassroomDetailsDto cdDto = cdMapper.mapToClassroomDetailsDto(cd1);
		return new ResponseEntity<>(cdDto , HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClassroomDetailsDto> updateClassroomIdById(int id, int classroomId) {
		Optional<ClassroomDetails>cd = cdRepo.findById(id);
		cd.get().setClassroomId(classroomId);
		ClassroomDetails cd1 = cdRepo.save(cd.get());
		ClassroomDetailsDto cdDto = cdMapper.mapToClassroomDetailsDto(cd1);
		return new ResponseEntity<> (cdDto , HttpStatus.OK);
	}
	}


