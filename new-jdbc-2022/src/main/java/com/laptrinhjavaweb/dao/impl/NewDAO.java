
package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}
	@Override
	public Long save(NewModel newModel) {
		//String sql = "INSERT INTO news(title, content, categoryid) VALUES(?,?,?)";
		StringBuilder sql = new StringBuilder("INSERT INTO news(title, content,");
		sql.append("thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(), newModel.getContent(),
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	
		/*
		 * ResultSet resultSet = null; Long id = null; Connection connection = null;
		 * PreparedStatement statement = null; try {
		 * 
		 * connection = getConnection(); //open connect connection.setAutoCommit(false);
		 * // tat che do tu dong auto conmit, defauls is true statement =
		 * connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //truyen
		 * câu sql vào đối tượng preparestatement statement.setString(1,
		 * newModel.getTitle());//set tham số cho đối tượng statement để truyền giá trụ
		 * vào tham số ? ? ? lưu xuống database statement.setString(2,
		 * newModel.getContent()); statement.setLong(3, newModel.getCategoryId());
		 * statement.executeUpdate(); //chạy hàm executeupdate để thực thi câu sql và
		 * lưu database xuống resultSet = statement.getGeneratedKeys(); // data create
		 * ra b thif laasy het // trả về id của bài viết if(resultSet.next()) { //trả về
		 * id của bài viết id= resultSet.getLong(1);// trả về id của bài viết }
		 * connection.commit();//chi khi commit thi thay doi database, chỉ commit thì dữ
		 * liệu mới được change return id; } catch (SQLException e) { if(connection !=
		 * null) { try { connection.rollback(); // nếu như mà ở trên tác vụ false thì
		 * rollback } catch (SQLException e1) { e1.printStackTrace(); } } return null;
		 * }finally { try { if (connection != null) { connection.close(); } if
		 * (statement != null) { statement.close(); } if (resultSet != null) {
		 * resultSet.close(); } } catch (SQLException e) { return null; }// khi thực thi
		 * sử dụng xong thì đóng lại hết }
		 */
	}
	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0); // is empty(0 trả về null, còn có giá trị thì trả về new.get(0)
	}
	@Override
	public void update(NewModel updateNew) {	
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ") ; //cắt chuỗi
		sql.append("shortdescription = ?, content = ?, categoryid = ?, ");	
		sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(),
				updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(),
				updateNew.getCreatedDate(),updateNew.getCreatedBy(), 
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
	}
	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}
}

