package com.tyss.alphaattendanceapp.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tyss.alphaattendanceapp.dao.UserDao;
import com.tyss.alphaattendanceapp.dto.User;
import com.tyss.alphaattendanceapp.exceptionclasses.DuplicateEmailException;
import com.tyss.alphaattendanceapp.exceptionclasses.DuplicatePhoneNumberException;
import com.tyss.alphaattendanceapp.exceptionclasses.IdNotFoundException;
import com.tyss.alphaattendanceapp.exceptionclasses.InvalidEmailException;
import com.tyss.alphaattendanceapp.exceptionclasses.InvalidPhoneNumberException;
import com.tyss.alphaattendanceapp.exceptionclasses.NoUserFoundException;
import com.tyss.alphaattendanceapp.responsestructure.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserDao userDao;

	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("swiftshoppapp@gmail.com");
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		System.out.println("Sending Mail...");
		javaMailSender.send(simpleMailMessage);
		System.out.println("Mail Sent Successfully...");
	}

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {

		if (!Pattern.compile("[6-9]{1}[0-9]{9}").matcher("" + user.getPhone()).matches())
			throw new InvalidPhoneNumberException();

//		if (Pattern.compile("[a-z,A-Z]{1,}[0-9]{0,}[a-z,A-Z]{0,}@gmail[.]com").matcher(user.getEmail()).matches())
//			throw new InvalidEmailException();

		if (userDao.findUserByPhoneNumber(user.getPhone()) != null)
			throw new DuplicatePhoneNumberException();

		if (userDao.findUserByEmail(user.getEmail()) != null)
			throw new DuplicateEmailException();

		
		user.setPassword(user.getEmail().substring(0, 4) + (user.getPhone() + "").substring(6, 10));
		user = userDao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setBody(user);
		structure.setMessage("User Saved Successfully...");
		structure.setStatusCode(HttpStatus.OK.value());
		sendEmail(user.getEmail(), "Alpha-Attendence Account Created!!!...", "Congrats Mr." + user.getName()
				+ " Your Alpha-Attendence Account Created Successfully... Your Username is your registerd Email and password is first four (4) charecters of your registerd email and last four digits of your registerd Phone Number...   ( Username : "+user.getEmail()+" & Password : "+user.getPassword()+" )  Regards     Team Aplha!!!...");
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {

		if (user.getId() == 0)
			throw new IdNotFoundException();

		user = userDao.updateUser(user);

		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setBody(user);
		structure.setMessage("User Updated Successfully...");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {

		Optional<User> optional = userDao.findUserById(id);

		if (optional.isEmpty())
			throw new IdNotFoundException();

		User user = optional.get();

		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setBody(user);
		structure.setMessage("User Found Successfully...");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id) {

		Optional<User> optional = userDao.findUserById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException();

		userDao.deleteUserById(id);

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setBody("User Delete Successfully...");
		structure.setMessage("User Delete From Database for the Provided ID Successfully...");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {

		List<User> users = userDao.findAllUsers();

		if (users.isEmpty())
			throw new NoUserFoundException();

		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setBody(users);
		structure.setMessage("Database Is Empty, No Users Are Their in Database...");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
