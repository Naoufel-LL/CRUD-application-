package metier;
public class User {
int id;
String login;
String password;
String email;
String ville;
public User() {
super();
}
public User(int id, String login, String password, String email, String ville) {
super();
this.id = id;
this.login = login;
this.password = password;
this.email = email;
this.ville = ville;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return this.email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}

}
