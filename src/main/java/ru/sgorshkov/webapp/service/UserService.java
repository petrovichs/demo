package ru.sgorshkov.webapp.service;

import ru.sgorshkov.webapp.model.ResponseObject;

public interface UserService {

    ResponseObject findAll(int page, int pageSize, String sortField, String sortDir);

}
