package ru.sgorshkov.webapp.mapper.impl;

import org.springframework.stereotype.Component;
import ru.sgorshkov.webapp.entity.UserEntity;
import ru.sgorshkov.webapp.mapper.Mapper;
import ru.sgorshkov.webapp.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements Mapper<UserEntity, UserModel> {

    @Override
    public UserModel convert(UserEntity entity) {
        UserModel user = new UserModel();
        user.setId(entity.getId());
        user.setName(normalizeName(entity));
        user.setEmail(entity.getEmail());
        return user;
    }

    private String normalizeName(UserEntity entity) {
        String firstName = "";
        if(entity.getFirstName() != null && !entity.getFirstName().isEmpty()){
            firstName = " " + entity.getFirstName().charAt(0) + ".";
        }

        return entity.getLastName() + firstName;
    }

    @Override
    public Iterable<UserModel> convertAll(Iterable<UserEntity> userEntities) {
        List<UserModel> userList = new ArrayList<>();

        for (UserEntity entity : userEntities) {
            UserModel user = convert(entity);
            userList.add(user);
        }
        return userList;
    }
}
