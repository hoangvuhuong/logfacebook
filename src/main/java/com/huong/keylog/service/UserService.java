package com.huong.keylog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huong.keylog.model.User;
import com.huong.keylog.model.UserBlock;
import com.huong.keylog.repository.UserBlockRepository;
import com.huong.keylog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserBlockRepository userBlockRepository;

	public int createUserBlock(UserBlock userBlock) {
		return userBlockRepository.create(userBlock);
	}

	public int create(User user) {
		return userRepository.create(user);
	}

	public Boolean checkUser(User u) {
		List<UserBlock> userBlocks = userBlockRepository.getByUsername(u.getUserName());
		// if(userBlocks == null || userBlocks.isEmpty()) {
		// List<User> arrUser = userRepository.findByUsername(u.getUserName());
		if (userBlocks != null) {
			for (UserBlock user : userBlocks) {
				if (user.getUserName().equals(u.getUserName()) 
						&& user.getPass().equals(u.getPass())
						&& !u.getUserName().isEmpty()
				/* && !u.getUserName().equals("huongtv1999@gmail.com") */) {
					return true;
				}
			}
		} else {
			return false;
		}
		// }

		return false;
	}
}
