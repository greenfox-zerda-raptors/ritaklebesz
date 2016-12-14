import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rita on 2016-12-14.
 */
@DatabaseTable(tableName = "address")
public class Address {
    @DatabaseField(generatedId = true)
    private int addrID;
    @DatabaseField
    private String street;
    @DatabaseField
    private String city;
    @DatabaseField
    private String country;
    @DatabaseField
    private int postcode;

    public Address() {
    }

    public Address(String street, String city, String country, int postcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "postcode= " + postcode + '\'' +
                ", city= '" + city + '\'' +
                ", country= '" + country + '\'' +
                ", street= '" + street + '\'' +
                '}';
    }

    public int getAddrID() {
        return addrID;
    }

    public void setAddrID(int addrID) {
        this.addrID = addrID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
