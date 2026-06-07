
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Angelica S. Fernando
 */
public class Users {

    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty middlename;
    private final StringProperty birthdate;
    private final StringProperty role;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty password;
    private final StringProperty confirmPassword;
    private final StringProperty status;
    private final StringProperty address;
    
    
    
        public Users(){
        id = new SimpleStringProperty(this, "id");
        username = new SimpleStringProperty(this, "username");
        firstname = new SimpleStringProperty(this, "firstname");
        lastname = new SimpleStringProperty(this, "lastName");
        middlename = new SimpleStringProperty(this, "middleName");
        birthdate = new SimpleStringProperty(this, "birthdate");
        role = new SimpleStringProperty(this, "role");
        email = new SimpleStringProperty(this, "email");
        phone = new SimpleStringProperty(this, "phone");
        password = new SimpleStringProperty(this, "password");
        confirmPassword = new SimpleStringProperty(this, "confirmPassword");
        status = new SimpleStringProperty(this, "status");
        address = new SimpleStringProperty(this, "address");
        
    }
    public StringProperty IdProperty(){return id;}
    public String getId() {return id.get();}
    public void setId(String newId){id.set(newId);}

    public StringProperty UsernameProperty(){return username;}
    public String getUsername() {return username.get();}
    public void setUsername(String newUsername){username.set(newUsername);}
    
    
    public StringProperty FirstnameProperty(){return firstname;}
    public String getFirstname() {return firstname.get();}
    public void setFirstname(String newFirstname){firstname.set(newFirstname);}
    
    public StringProperty LastnameProperty(){return lastname;}
    public String getLastName() {return lastname.get();}
    public void setLastname(String newLastname){lastname.set(newLastname);}

    public StringProperty MiddlenameProperty(){return middlename;}
    public String getMiddleName() {return middlename.get();}
    public void setMiddlename(String newMiddlename){middlename.set(newMiddlename);}
    
    public StringProperty PhoneProperty(){return phone;}
    public String getPhone() {return phone.get();}
    public void setPhone(String newPhone){phone.set(newPhone);}
    
    public StringProperty BirthdateProperty(){return birthdate;}
    public String getBirthdate() {return birthdate.get();}
    public void setBirthdate(String newBirthdate){birthdate.set(newBirthdate);}

    public StringProperty RoleProperty(){return role;}
    public String getRole() {return role.get();}
    public void setRole(String newRole){role.set(newRole);}

    public StringProperty EmailProperty(){return email;}
    public String getEmail() {return email.get();}
    public void setEmail(String newEmail){email.set(newEmail);}
    
    public StringProperty PasswordProperty(){return password;}
    public String getPassword() {return password.get();}
    public void setPassword(String newPassword){password.set(newPassword);}
    
    public StringProperty ConfirmPasswordProperty(){return confirmPassword;}
    public String getConfirmPassword() {return confirmPassword.get();}
    public void setConfirmPassword(String newConfirmPassword){confirmPassword.set(newConfirmPassword);}

    public StringProperty StatusProperty(){return status;}
    public String getStatus() {return status.get();}
    public void setStatus(String newStatus){status.set(newStatus);}
        
    public StringProperty AddressProperty(){return address;}
    public String getAddress() {return address.get();}
    public void setAddress(String newAddress){address.set(newAddress);}
    

        
        
    
}
