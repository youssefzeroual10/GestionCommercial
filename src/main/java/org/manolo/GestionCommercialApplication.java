package org.manolo;

import java.util.ArrayList;
import java.util.List;

import org.manolo.entities.Role;
import org.manolo.entities.User;
import org.manolo.metier.RoleMetier;
import org.manolo.metier.UserMetier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GestionCommercialApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GestionCommercialApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(GestionCommercialApplication.class, args);
		PasswordEncoder encoder = new BCryptPasswordEncoder();		
		UserMetier userMetier = ctx.getBean(UserMetier.class);
		RoleMetier roleMetier = ctx.getBean(RoleMetier.class);
		roleMetier.saveRole(new Role("SUPER_ADMIN", "super administrateur"));
		String pwd="admin123";
		User user = new User();
		List <Role> roles = new ArrayList<Role>();;
		Role role= roleMetier.getRole("SUPER_ADMIN");
		roles.add(role);
		user.setEmail("youssef.zeroual.jamal@gmail.com");
		user.setIdUser("n344235");
		user.setNom("zeroual");
		user.setPrenom("youssef");
		user.setTelephone("0619780175");
		user.setPassword(encoder.encode(pwd));
		user.setRoles(roles);
		userMetier.userAdding(user);
		
	}
}
