
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class history {

    private final StringProperty id;
    private final StringProperty username;
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty middlename;
    private final StringProperty address;
    private final StringProperty phone;
    private final StringProperty Proname;
    private final StringProperty Proqua;
    private final StringProperty Proprice;

    public history() {
        id = new SimpleStringProperty(this, "id");
        username = new SimpleStringProperty(this, "username");
        firstname = new SimpleStringProperty(this, "firstname");
        lastname = new SimpleStringProperty(this, "lastName");
        middlename = new SimpleStringProperty(this, "middleName");
        address = new SimpleStringProperty(this, "address");
        phone = new SimpleStringProperty(this, "phone");
        Proname = new SimpleStringProperty(this, "Pronam");
        Proqua = new SimpleStringProperty(this, "Proqua");
        Proprice = new SimpleStringProperty(this, "Proprice");

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
    

        
    public StringProperty AddressProperty(){return address;}
    public String getAddress() {return address.get();}
    public void setAddress(String newAddress){address.set(newAddress);}
    
    public StringProperty PronameProperty(){return Proname;}
    public String getProname(){return Proname.get();}
    public void setProname(String newProname){Proname.set(newProname);}
    
    public StringProperty ProquaProperty(){return Proqua;}
    public String getProqua(){return Proqua.get();}
    public void setProqua(String newProqua){Proqua.set(newProqua);}
    
    
    public StringProperty PropriceProperty(){return Proprice;}
    public String getProprice(){return Proprice.get();}
    public void setProprice(String newProprice){Proprice.set(newProprice);}
    
}
