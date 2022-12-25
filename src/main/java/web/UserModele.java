package web;
import java.util.*;
import metier.User;  
public class UserModele {
private String ville;
private String email;
private String login;
private String password;

private List<User> users=new ArrayList<User>();
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
