package ru.sgorshkov.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sgorshkov.webapp.entity.UserEntity;
import ru.sgorshkov.webapp.mapper.Mapper;
import ru.sgorshkov.webapp.model.ResponseObject;
import ru.sgorshkov.webapp.repo.UserRepository;
import ru.sgorshkov.webapp.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Resource(name = "userMapper")
    Mapper userMapper;

    @Override
    public ResponseObject findAll(int page, int pageSize, String sortField, String sortDir) {
        Sort.Direction dir = sortDir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page - 1, pageSize, dir, sortField);
        Page<UserEntity> userEntities = userRepo.findAll(pageable);
        return new ResponseObject(userMapper.convertAll(userEntities), userEntities.getTotalElements());
    }

}
