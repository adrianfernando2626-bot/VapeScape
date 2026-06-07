
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class inventory {
    private final StringProperty id;
    private final StringProperty Proname;
    private final StringProperty Proqua;
    private final StringProperty Proprice;
    private final StringProperty Image;
    
    
    public inventory(){
        id = new SimpleStringProperty(this, "id");
        Proname = new SimpleStringProperty(this, "Pronam");
        Proqua = new SimpleStringProperty(this, "Proqua");
        Proprice = new SimpleStringProperty(this, "Proprice");
        Image = new SimpleStringProperty(this, "Image");
    }
    
    public StringProperty idProperty(){return id;}
    public String getid(){return id.get();}
    public void setid(String newid){id.set(newid);}
    
    public StringProperty PronameProperty(){return Proname;}
    public String getProname(){return Proname.get();}
    public void setProname(String newProname){Proname.set(newProname);}
    
    public StringProperty ProquaProperty(){return Proqua;}
    public String getProqua(){return Proqua.get();}
    public void setProqua(String newProqua){Proqua.set(newProqua);}
    
    
    public StringProperty PropriceProperty(){return Proprice;}
    public String getProprice(){return Proprice.get();}
    public void setProprice(String newProprice){Proprice.set(newProprice);}
        
    public String getImage(){return Image.get();}
    public void setImage(String newImage){Image.set(newImage);}
    
}
