package repository;

import base.BaseRepositoryImpel;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpel extends BaseRepositoryImpel<Integer, Category> implements CategoryRepository {


    public CategoryRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return " category ";
    }

    @Override
    public String getColumnId() {
        return "category_id";
    }

    @Override
    public String getColumnModelName() {
        return " category_name";
    }

    @Override
    public Category mapResultSet(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt("category_id"));
        category.setCategoryName(resultSet.getString("category_name"));
        return (Category) category;
    }

    @Override
    public String getCountOfQuestionMarks() {
        return "(?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Category category, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, category.getCategoryName());

    }

    @Override
    public String getUpdateQueryParams() {
        return  " category_name = ?";
    }

    @Override
    public String getCulumnsname() {
        return " (category_name) ";
    }

}
