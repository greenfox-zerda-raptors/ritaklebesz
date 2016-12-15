package com.greenfox.ritaklebesz;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rita on 2016-11-17.
 */
public class ListOfItems {

    private List<Item> listOfItems;
    private String databaseUrl = "jdbc:mysql://127.0.0.1:3306/todoappdb?user=root&password=rita1";
    private ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
    private Dao<Item, Integer> itemDao = DaoManager.createDao(connectionSource, Item.class);
    private QueryBuilder<Item, Integer> queryBuilder = itemDao.queryBuilder();

    public ListOfItems() throws SQLException {
        loadFromDatabase();
    }

    private void loadFromDatabase() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Item.class);
        listOfItems = queryBuilder.orderBy("done", true).where().eq("archived", 0).query();
    }

    public void addItemIfNotExists(Item item) throws SQLException {
        if (itemDao.queryForId(item.getNumber()) == null) {
            itemDao.create(item);
        }
    }

    public void add(Item item) throws SQLException {
        addItemIfNotExists(item);
        loadFromDatabase();
    }

    public void remove(int num) throws SQLException {
        for (Item item : listOfItems) {
            if (num == item.getNumber()) {
                item.setArchived(true);
                itemDao.update(item);
            }
        }
        loadFromDatabase();
    }

    public void complete(int num) throws SQLException {
        for (Item item : listOfItems) {
            if (num == item.getNumber()) {
                item.setDone(true);
                itemDao.update(item);
            }
        }
        loadFromDatabase();
    }

    public void changeState(int num, JCheckBox box) throws SQLException {
        for (Item item : listOfItems) {
            if (num == item.getNumber()) {
                item.setDone(box.isSelected());
                itemDao.update(item);
            }
        }
        loadFromDatabase();
    }

    @Override
    public String toString() {
        return "ListOfItems{" +
                "listOfItems=" + listOfItems +
                '}';
    }

    public void list() {
        if (listOfItems.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (Item item : listOfItems) {
                System.out.println(item.toString());
            }
        }
    }

    public int size() {
        return listOfItems.size();
    }

    public Item get(int i) {
        return listOfItems.get(i);
    }
}
