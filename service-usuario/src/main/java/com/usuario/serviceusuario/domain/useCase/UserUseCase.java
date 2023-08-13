package com.usuario.serviceusuario.domain.useCase;

import com.usuario.serviceusuario.application.dto.RestaurantResponseDto;
import com.usuario.serviceusuario.domain.api.IUserServicePort;
import com.usuario.serviceusuario.domain.model.Employee;
import com.usuario.serviceusuario.domain.model.Restaurant;
import com.usuario.serviceusuario.domain.model.Role;
import com.usuario.serviceusuario.domain.model.User;
import com.usuario.serviceusuario.domain.spi.IUserPersistencePort;
import com.usuario.serviceusuario.domain.spi.token.IToken;
import com.usuario.serviceusuario.infrastructure.out.feignclients.IRestaurantFeignClient;
import com.usuario.serviceusuario.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    private final IRestaurantFeignClient restaurantFeignClient;
    private final PasswordEncoder passwordEncoder;
    private final IToken token;



    public UserUseCase(IUserPersistencePort userPersistencePort, IRestaurantFeignClient restaurantFeignClient, PasswordEncoder passwordEncoder, IToken token) {
        this.userPersistencePort = userPersistencePort;
        this.restaurantFeignClient = restaurantFeignClient;
        this.passwordEncoder = passwordEncoder;
        this.token = token;
    }

    @Override
    public void saveUser(User user) {
        validateRolesAuthAndNot(user);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userPersistencePort.saveUser(user);
    }

    @Override
    public void savetEmployee(User user) {
        Employee employee = new Employee();
        String beareToken = token.getBearerToken();
        Long idOwnerAut = token.getUserAuthenticatedId(beareToken);

        RestaurantResponseDto restaurant = restaurantFeignClient.getRestaurantByIdProprietor(idOwnerAut);
        String restaurantId = String.valueOf(restaurant.getId());
        System.out.println(restaurantId);
        String employeeId = String.valueOf(userPersistencePort.getUserByMail(user.getMail()).getId());
        System.out.println(employeeId);

        employee.setRestaurantId(restaurantId);
        employee.setEmployeeId(employeeId);
        userPersistencePort.

    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

    @Override
    public User getUserByMail(String mail) {
        return userPersistencePort.getUserByMail(mail);
    }

    @Override
    public Boolean validateUserHasRole(Long userId, String requiredRole) throws Exception {
        UserEntity user = userPersistencePort.findUserById(userId).orElseThrow(() -> new Exception("User not found"));
        return user.getRole().getName().equals(requiredRole);
    }

    private void validateRolesAuthAndNot(User user) {
        String bearerToken = token.getBearerToken();
        Role role = new Role();
        String roles = "";
        if (!(bearerToken == null)) {

            roles = token.getUserAuthenticatedRole(bearerToken);
            System.out.println(roles);
        }

        if (roles.equals("PROPIETARIO")) {
            //Puede crear empleados
            role.setId(3L);
        } else if (roles.equals("ADMIN")) {
            //Puede crear propietarios
            role.setId(2L);
        } else {
            if (user.getRole().getId() == null) {
                role.setId(4L);
            } else if (user.getRole().getId() == 1) {
                //Si entra aqui, se registra un ADMIN
                System.out.println("Se esta registrando un ADMIN");
            }

        }
        if (!(role.getId()==null)){
            user.setRole(role);
        }
    }
}
