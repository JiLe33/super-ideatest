package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import generator.Common.R;
import generator.Common.ThreadUtil;
import generator.domain.Nine;
import generator.domain.VO.live;
import generator.service.NineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/nine")
public class NineController {
    @Autowired
    private NineService nineService;
    @GetMapping("/listA")
    public R<List<Nine>> list (){

        List<Nine> list = nineService.list();
        return R.success(list);
    }
    @PutMapping("/addA")
    public R<String> add (@RequestBody Nine nine){
//        String name = score.getName();
//        LambdaQueryWrapper<Score> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(Score::getName,name);
//        Score one = scoreService.getOne(lambdaQueryWrapper);
//        if(one!=null){
//        throw new ScoreExe("该学生已经存在");
//
//        }

        nineService.save(nine);

        return R.success("添加成功");
    }
    @DeleteMapping("/delA/{name}")
    public  R<String> del (@PathVariable String name){
        String name1=name;
        LambdaQueryWrapper<Nine> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Nine::getEc,name1);
        nineService.remove(queryWrapper);
        return R.success("删除成功");
    }
    @GetMapping("/listB")
    public R<live> listB() {
        int a=0;//吃饭支出
        int b=0;//其他支出
        List<Nine> list = nineService.list();
        for(Nine  nine:list){
            String ec = nine.getEc();
            if(ec.equals("吃饭支出")){
                a+= nine.getNum();
            }else {
                b+= nine.getNum();
            }
        }
       if(a>((a+b)/2)){
           return R.success(new live("贫困"));
       }if(a<((a+b)/5)) {
            return R.success(new live("小康"));
       }
        else
            return R.success(new live("温饱"));


    }
    @DeleteMapping("/loginoutA")
    public R loginout(){
        ThreadUtil.remove();
        return R.success("退出成功");
    }
}
