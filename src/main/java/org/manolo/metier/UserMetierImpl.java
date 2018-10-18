package org.manolo.metier;


import java.util.Collection;
import java.util.List;
import org.manolo.entities.User;
import org.manolo.dao.UserRepository;
import org.manolo.entities.Commande;
import org.manolo.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserMetierImpl  implements UserMetier{
	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public void deleteUser(String idUser) {
		userRepository.delete(userRepository.findOne(idUser));
		
	}
	@Override
	public User addUser(String idUser,String password,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
		User user = new User();
		user.setIdUser(idUser);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setTelephone(telephone);
		user.setAdresse(adresse);
		user.setEmail(email);
		user.setDateEmbauche(dateEmbauche);
		user.setRoles(role);
		return userRepository.save(user);
	}
	@Override
	public User updateUser(String idUser,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche) {
		User user = userRepository.findOne(idUser);
		
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setTelephone(telephone);
		user.setAdresse(adresse);
		user.setEmail(email);
		user.setDateEmbauche(dateEmbauche);
		user.setRoles(role);
		return userRepository.save(user);
	}
	@Override
	public User updateUser2(String idUser,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche,String pwdAncien,String pwd1) {
		User user = userRepository.findOne(idUser);
		User user2 =null;
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(pwd1);
		if(bCryptPasswordEncoder.matches(pwdAncien,user.getPassword())){
			user.setNom(nom);
			user.setPassword(bCryptPasswordEncoder.encode(pwd1));
			user.setPrenom(prenom);
			user.setTelephone(telephone);
			user.setAdresse(adresse);
			user.setEmail(email);
			user.setDateEmbauche(dateEmbauche);
			user.setRoles(role);
			user2 = user;
		}else{throw new RuntimeException("l'ancien mot de passe est incorrect !!!");}
		return user2;
	}
	@Override
	public List<Commande> CommandesByUser(String idUser) {
		return userRepository.CommandesByUser(idUser);
	}
	@Override
	public PageUser getAllUser(int size, int page) {
		Page<User> ops = userRepository.getAllUsers(new PageRequest(page, size));
		PageUser pEt = new PageUser();
		pEt.setUser(ops.getContent());
		pEt.setNombreUsers(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalUsers((int)ops.getTotalElements());
		return pEt; 
	}
	@Override
	public PageUser getByUsersMotCle(String motCle, int size, int page) {
		Page<User> ops = userRepository.getUsersByMotCle(motCle,new PageRequest(page, size));
		PageUser pEt = new PageUser();
		pEt.setUser(ops.getContent());
		pEt.setNombreUsers(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalUsers((int)ops.getTotalElements());
		return pEt; 	
	}
	@Override
	public User getUser(String id) {
		return userRepository.findOne(id);
				
	}
	@Override
	public int getCountUser() {
		return userRepository.getCountUser();
	}
	@Override
	public User getUserAuth(String idUser, String password) {
		User user=userRepository.getUserAuth(idUser, password);
		return user;
	}
	@Override
	public PageUser getUsersCredit(int size, int page) {
		Page<User> ops = userRepository.getUsersCredit(new PageRequest(page, size));
		PageUser pEt = new PageUser();
		pEt.setUser(ops.getContent());
		pEt.setNombreUsers(ops.getNumberOfElements());
		pEt.setPage(ops.getNumber());
		pEt.setTotalPages(ops.getTotalPages());
		pEt.setTotalUsers((int)ops.getTotalElements());
		return pEt; 
	}
	@Override
	public User userAdding(User user) {
		return userRepository.save(user);
	}
}
