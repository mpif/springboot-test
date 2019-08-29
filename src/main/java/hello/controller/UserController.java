package hello.controller;

import hello.entity.OrderUser;
import hello.entity.User;
import hello.repository.OrderUserRepository;
import hello.repository.UserRepository;
import hello.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

/**
 * @author: mpif
 * @date: 2019-08-29 09:54
 */
@Controller
@RequestMapping(path="/user")
public class UserController {

//    @Autowired
    @Resource
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String username,
                       @RequestParam String password,
                       @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAmount(amount);
        userRepository.save(user);
        return "Saved";
    }

    @RequestMapping(path="/addAmount", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String addAmount (@RequestParam Integer id, @RequestParam Integer amount) {

        try {
            Optional<User> userOpt = userRepository.findById(id);
            if(userOpt != null) {
                User user = userOpt.get();
                Integer oldAmount = user.getAmount();
                user.setAmount(oldAmount + amount);
                user.setUpdateTime(DateUtils.formatYYYYMMDDHHMMSS(new Date()));
                userRepository.save(user);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Add Amount Success!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


}
