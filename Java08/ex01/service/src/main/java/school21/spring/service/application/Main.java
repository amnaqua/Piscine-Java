package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		UsersRepository userRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
		System.out.println(userRepository.findAll());
		System.out.println("-------------------------");
		userRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
		System.out.println(userRepository.findAll());
		System.out.println("-------------------------");
		System.out.println(userRepository.findByEmail("first"));
		System.out.println(userRepository.findByEmail("second"));
		System.out.println(userRepository.findByEmail("third"));
		System.out.println(userRepository.findByEmail("fourth"));
		System.out.println(userRepository.findByEmail("fifth"));
		System.out.println(userRepository.findByEmail("123"));
		System.out.println("-------------------------");
		System.out.println(userRepository.findById(1L));
		System.out.println(userRepository.findById(2L));
		System.out.println(userRepository.findById(3L));
		System.out.println(userRepository.findById(4L));
		System.out.println(userRepository.findById(5L));
		System.out.println("-------------------------");
		User user = new User(1L, "firstTest");
		userRepository.update(user);
		System.out.println(userRepository.findById(1L));
		System.out.println("-------------------------");
		User user1 = new User(6L, "sixth");
		userRepository.save(user1);
		System.out.println(userRepository.findById(6L));
		System.out.println("-------------------------");
		userRepository.delete(1L);
		userRepository.delete(2L);
		userRepository.delete(3L);
		userRepository.delete(4L);
		userRepository.delete(5L);
		userRepository.delete(6L);
	}
}
