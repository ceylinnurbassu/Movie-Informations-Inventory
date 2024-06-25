
package movieınformationsınventory;
public class Actor {
    // Private member variables.
    private String nameSurname;
    private String gender;
    private String nationality;

    // Default constructor.
    public Actor()
    {
        this.nameSurname = null;
        this.gender = null;
        this.nationality = null;
    }

    // Parameterized constructor.
    public Actor(String name, String genderOfActor, String country)
    {
        this.nameSurname = name;
        this.gender = genderOfActor;
        this.nationality = country;
    }

    // Copy constructor.
    public Actor(Actor other)
    {
        this.nameSurname = other.nameSurname;
        this.gender = other.gender;
        this.nationality = other.nationality;
    }
    // Getter for nameSurname.
    public String getNameSurname() {
        return nameSurname;
    }
    // Setter for nameSurname.
    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }
    // Getter for gender.
    public String getGender() {
        return gender;
    }
    // Setter for gender.
    public void setGender(String gender) {
        this.gender = gender;
    }
    // Getter for nationality.
    public String getNationality() {
        return nationality;
    }
    // Setter for nationality.
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // Overriding the toString() method to  create a string representation of an Actor object.
    @Override
    public String toString(){
        return "Name and Surname: "+nameSurname+" Gender: "+gender+" Nationality: "+nationality;
    }
}
