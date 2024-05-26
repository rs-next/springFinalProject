package kr.co.inhatcspring.database;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.inhatcspring.beans.freeBoardVO;

public interface MapperInterface {

    
	@Insert("INSERT INTO freeboard (writer, title, boardContent, nowDate, boardCategory) " +
	        "VALUES (#{writer}, #{title}, #{boardContent}, SYSDATE, #{boardCategory})")
	void write_board(freeBoardVO freeBoardVO);
	
	@Update("UPDATE freeboard SET title = #{title}, boardContent = #{boardContent} WHERE boardID = #{boardID}")
	void update_board(freeBoardVO freeBoardVO);
	
    @Select("SELECT * FROM freeboard where boardCategory = #{boardCategory} order by nowDate desc")
    List<freeBoardVO> search_board(String boardCategory);
    
    @Select("SELECT * FROM freeboard where boardID = #{boardID}")
    freeBoardVO view_board(int boardID);
    
    @Delete("DELETE FROM freeboard where boardID = #{boardID}")
    void delete_board(int boardID);
}
