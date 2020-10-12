package com.alejandro.zemsaniaTest;

import com.alejandro.zemsaniaTest.models.User;
import com.alejandro.zemsaniaTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ZemsaniaTestApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers(){
		repository.saveAll(readUsers());
	}

	public List<User> readUsers() {
		List<User> users = new LinkedList<User>();

		try {
			File usersFile = new File(getClass().getClassLoader().getResource("userList.txt").getFile());
			Scanner scanner = new Scanner(usersFile);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] separatedLine = line.split(",");
				String username =  separatedLine[0].trim();
				String password = separatedLine[1].trim();
				users.add(new User(username,password));
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("Users list not found");
		}
		return users;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZemsaniaTestApplication.class, args);
	}

}

