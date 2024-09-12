package register.servletex;

public class User {

	String name;
	String profession;
	int applicationID;
	int age;
	String agenda;
	
	
	public User(String name, int age, String profession) {
		super();
		this.name = name;
		this.profession = profession;
		this.age = age;
	}
	public User() {
		super();
	}
	public User(String name, String profession, int age, String agenda) {
		super();
		this.name = name;
		this.profession = profession;
		this.age = age;
		this.agenda = agenda;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAgenda() {
		return agenda;
	}
	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", profession=" + profession + ", applicationID=" + applicationID + ", age=" + age
				+ ", agenda=" + agenda + "]";
	}
	
	
	
}
