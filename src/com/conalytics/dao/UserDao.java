package com.conalytics.dao;

import java.util.List;

import com.conalytics.domain.User;

public interface UserDao {
	public void insertData(User user);

	public List<User> getUserList();

	public void updateData(User user);

	public void deleteData(String id);

	public User getUser(String id);

}
