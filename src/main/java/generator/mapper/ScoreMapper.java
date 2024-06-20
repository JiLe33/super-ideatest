package generator.mapper;

import generator.domain.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 花见
* @description 针对表【score】的数据库操作Mapper
* @createDate 2024-06-15 16:22:27
* @Entity generator.domain.Score
*/
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

//    @Select("SELECT name FROM score_system.score GROUP BY name HAVING SUM(bscore = 0) > (COUNT(*) / 3)");
List<String> selectone();
}




