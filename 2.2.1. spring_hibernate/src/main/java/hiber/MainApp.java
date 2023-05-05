package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
//      User firstUser = new User("Ekaterina", "Voskresenskaya", "vekser@mai.ru");
//      Car firstUserCar = new Car("Audi", 3);
//      User secondUser = new User("Vladislav ", "Petrov", "vpetr@mai.ru");
//      Car secondUserCar = new Car("Camry", 6);
//      User thirdUser = new User("Oleg", "Lapin", "olapin@mai.ru");
//      Car thirdUserCar = new Car("Lada", 10);
//      firstUser.setCar(firstUserCar);
//      secondUser.setCar(secondUserCar);
//      thirdUser.setCar(thirdUserCar);
//      userService.add(firstUser);
//      userService.add(secondUser);
//      userService.add(thirdUser);

      System.out.println(userService.getUserByCar("Camry", 6));
      System.out.println(userService.getUserByCar("Audi", 3));
      System.out.println(userService.getUserByCar("Lada", 10));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
