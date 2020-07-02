package spring.country.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.country.controllers.dto.UserRegistrationDto;
import spring.country.model.User;


/**
 * @Created 29 / 06 / 2020 - 6:47 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
