package by.itclass.model.db;

import by.itclass.constants.AppConstant;
import by.itclass.model.properties.PropertyManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;

public class ConnectionManager {
    private static Connection cn;
    private static Properties properties;

    static {
        properties = PropertyManager.getProperties(AppConstant.DB_PROPERTY_FILE);

        try {
            Class.forName(properties.getProperty(AppConstant.DB_DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //проверить когда открыто для двух клиентов
    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(cn) || cn.isClosed()) {
            cn = DriverManager.getConnection(properties.getProperty(AppConstant.DB_URL), properties);
        }
        return cn;
    }

    public static void closeConnection() {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
