import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workshop02 {
    public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:mysql://127.0.0.1:3306/workshop02?user=root&password=rita1";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        ArrayList<String> newCustomers = new ArrayList<>(Arrays.asList("Captain America", "Iron Man", "Wolverine", "Hulk", "Loki"));
        for (String customer : newCustomers) {
            createAccountIfNotExists(accountDao, new Account(customer));
        }

        QueryBuilder<Account, String> queryBuilder = accountDao.queryBuilder();
        List<Account> accounts = queryBuilder.orderBy("name", true).query();
        for (Account account : accounts) {
            System.out.println(account.getName());
        }
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if (accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }
}
