package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Score;
import generator.service.ScoreService;
import generator.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 花见
* @description 针对表【score】的数据库操作Service实现
* @createDate 2024-06-18 00:26:34
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{

    @Autowired
    private ScoreMapper scoreMapper;
    public List<String> getName(){
        return  scoreMapper.selectone();
    }
}




