package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import generator.Common.R;
import generator.Common.ThreadUtil;
import generator.Exception.ScoreExe;
import generator.domain.Score;
import generator.domain.VO.A;
import generator.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class W {
    @Autowired
    private ScoreService scoreService;
    @GetMapping("/listA")
    public R<List<Score>> list (){
        //ThreadUtil.sleep(3000);
        List<Score> list = scoreService.list();
        return R.success(list);
    }
    @PutMapping("/addA")
    public R<String> add (@RequestBody Score score){
//        String name = score.getName();
//        LambdaQueryWrapper<Score> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(Score::getName,name);
//        Score one = scoreService.getOne(lambdaQueryWrapper);
//        if(one!=null){
//        throw new ScoreExe("该学生已经存在");
//
//        }

        scoreService.save(score);

        return R.success("添加成功");
    }
    @DeleteMapping("/delA/{name}")
    public  R<String> del (@PathVariable String name){
        String name1=name;
        LambdaQueryWrapper<Score> queryWrapper = new LambdaQueryWrapper<>();
       queryWrapper.eq(Score::getName,name1);
        scoreService.remove(queryWrapper);

        return R.success("删除成功");
    }
   @GetMapping("/listB")
   public R<List<String>> listB() {
//       int a=0;//缺勤次数
//       int b=0;//出勤次数
//       List<Score> list = scoreService.list();
//       generator.domain.VO.Score score1 = new generator.domain.VO.Score();
//       for (Score score : list) {
//           LambdaQueryWrapper<Score>lambdaQueryWrapper=new LambdaQueryWrapper<>();
//           lambdaQueryWrapper.eq(Score::getName,score.getName());
//           Score one = scoreService.getOne(lambdaQueryWrapper);
//
//           Integer bscore = score.getBscore();
//           if(bscore==0){
//               a++;
//           }else{
//               b++;
//           }
//       }
//       if(a>(a+b)/3){
//           score1.setStatus("");
//       }
//       return R.success(score1);
       List<String> name = scoreService.getName();
       return  R.success(name);

   }
    @DeleteMapping("/loginoutA")
    public R loginout(){
        ThreadUtil.remove();
        return R.success("退出成功");
    }



}
