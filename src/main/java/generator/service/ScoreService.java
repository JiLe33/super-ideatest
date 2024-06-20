package generator.service;

import generator.domain.Score;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 花见
* @description 针对表【score】的数据库操作Service
* @createDate 2024-06-18 00:26:34
*/
public interface ScoreService extends IService<Score> {
List<String> getName();
}
