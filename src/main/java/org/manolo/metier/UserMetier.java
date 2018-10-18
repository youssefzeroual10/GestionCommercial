package org.manolo.metier;

import java.util.Collection;
import java.util.List;

import org.manolo.entities.User;
import org.manolo.entities.Commande;
import org.manolo.entities.Role;

public interface UserMetier {
	public List<User> getAllUsers();
	public  User updateUser(String idUser,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche);
	public  User updateUser2(String idUser,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche,String pwd,String pwd1);
	public void deleteUser(String idUser);
	public  User addUser(String idUser,String password,String nom,String prenom,String email,String adresse,String telephone,Collection<Role> role,String dateEmbauche);
	public  User getUser(String id);
	public  int getCountUser();
	public List<Commande> CommandesByUser(String idUser);
	public PageUser getAllUser(int size,int page);
	public PageUser getByUsersMotCle(String motCle,int size,int page);
	public User getUserAuth(String idUser,String password);
	public PageUser getUsersCredit(int size,int page);
	public User userAdding(User user);

}
