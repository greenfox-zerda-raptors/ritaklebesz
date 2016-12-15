import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rita on 2016-12-14.
 */
@DatabaseTable(tableName = "accounts")
public class Account {
    @DatabaseField(id = true)
    private String name;
    @DatabaseField
    private String password;
    @DatabaseField(columnName = "addrID", foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Address address;

    public Account() {
    }

    public Account(String name) {
        this(name, "1234");
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account(String name, String password, Address address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "name='" + name + '\'' +
                ", address=" + address.toString() + '\'' +
                '}';
    }
}
