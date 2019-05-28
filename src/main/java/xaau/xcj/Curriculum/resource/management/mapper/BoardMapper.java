package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.Board;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 17:41
 * @message:
 */
public interface BoardMapper {
        // 查询总的留言数
        public int allConsumeNum();

        // 分列查询留言
        public List<Board> findConsumeToNum(@Param("ns") int ns, @Param("ps") int ps);

        // 管理员添加留言
        public int addConsume(@Param("board") Board board);

        //查询用户信息
        @Select("select NAME from `user` WHERE id=#{id} ")
        public String getUserName(@Param("id")int id);


}
