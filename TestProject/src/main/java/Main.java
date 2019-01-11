import dao.entity.Festival;
import dao.entity.Performer;
import dao.entity.User;
import dao.entity.enums.TypeEvent;
import service.UserService;
import utils.Connector;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args){

        UserService userService = new UserService();
        User user = new User("Mike", "Mouse", 45, "none", "87654321", "", "+375291234567", "0000000000000000");
       /* user.setFirstName("Mike");
        user.setLastName("Mouse");
        user.setAge(31);
        user.setEmail("mikeandmouse@gmail.com");
        user.setPassword("12345678");
        user.setActivationCode("");
        user.setPhoneNumber("+375291234567");
        user.setCardNumber("0000000000000000");*/
        userService.saveUser(user);

         /*  User user = null;
        Festival festival = null;
        Performer performer = null;
        Connector connector = new Connector("localhost:3306", DB, USERNAME, PASSWORD);
        try {
            connector.openConnection();
            System.out.println("Connected successfully");

            user = connector.addUser(18);
            System.out.println("Id = " + user.getId() + ", имя = " + user.getFirstName() + ", фамилия = " + user.getLastName() +
                        ", возраст = " + user.getAge());

            festival = connector.addFest(TypeEvent.MUSIC_FESTIVAL.name());
            System.out.println("Id = " + festival.getId() + ", фестиваль = " + festival.getName() + ", описание " +
                        festival.getDescription() + ", максимальное кол-во мест = " + festival.getCountPlace() + ", цена = " + festival.getPrice() + " руб.");

        } catch (SQLException e) {
            System.out.println("Error open connection sql \n" + e.getMessage());
        }*/

    }
}

