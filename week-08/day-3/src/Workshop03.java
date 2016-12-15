import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class Workshop03 {
    public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:mysql://127.0.0.1:3306/workshop03?user=root&password=rita1";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);
        TableUtils.createTableIfNotExists(connectionSource, Address.class);

        Dao<Account, String> accountDao =
                DaoManager.createDao(connectionSource, Account.class);
        Dao<Address, Integer> addressDao =
                DaoManager.createDao(connectionSource, Address.class);


        Account account = new Account("Captain America", "uejnsd632**234.", new Address("Andrassy ut 66.", "Budapest", "Hungary", 1066));
        System.out.println(account.toString());
        System.out.println(account.getAddress().toString());
        createAccountIfNotExists(accountDao, account);

        Account account2 = new Account("Hulk", "ufstsd632**603.");
        createAccountIfNotExists(accountDao, account2);
        Address address = new Address("Andrassy ut 70.", "Budapest", "Hungary", 1066);
        createAddressIfNotExists(addressDao, address);
        account2.setAddress(address);
        accountDao.update(account2);
        accountDao.refresh(account2);
        addressDao.refresh(account2.getAddress());

        Account account3 = new Account("Batman", "ufdssd632**182.");
        createAccountIfNotExists(accountDao, account3);
        account3.setAddress(new Address("Andrassy ut 78.", "Budapest", "Hungary", 1066));
        createAddressIfNotExists(addressDao, account3.getAddress());
        accountDao.update(account3);

        Account account4 = new Account("Iron Man", "uejnsd632**278.", new Address("Andrassy ut 66.", "Budapest", "Hungary", 1066));
        createAccountIfNotExists(accountDao, account4);


        account = accountDao.queryForId("Captain America");
        System.out.println("Account: " + account.toString());
        account2 = accountDao.queryForId("Hulk");
        System.out.println("Account: " + account2.toString());

    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if (accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }

    private static void createAddressIfNotExists(Dao<Address, Integer> addressDao, Address addr) throws SQLException {
        QueryBuilder<Address, Integer> queryBuilder = addressDao.queryBuilder();
        List<Address> isAddress = queryBuilder.where().eq("street", addr.getStreet()).
                and().
                eq("city", addr.getCity()).
                and().
                eq("country", addr.getCountry()).
                and().
                eq("postcode", addr.getPostcode()).query();
        if (isAddress.size() == 0) {
            addressDao.create(addr);
        }
    }
}
