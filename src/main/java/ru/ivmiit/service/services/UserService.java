package ru.ivmiit.service.services;

import ru.ivmiit.service.forms.UserForm;
import ru.ivmiit.service.models.User;

import java.util.List;

public interface UserService {
    void signUp(UserForm userForm);

    Boolean checkLogin(String login);

    User findOne(Long userId);

    List<User> findAll();
}
