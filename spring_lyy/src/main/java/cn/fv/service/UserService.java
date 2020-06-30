package cn.fv.service;

import cn.fv.pojo.User;

import java.util.List;

public interface UserService {
    User getById(int id);

    List<User> getAll();

    void add(User user);
}
