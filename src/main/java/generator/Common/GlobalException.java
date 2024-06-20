package generator.Common;

import generator.Exception.ScoreExe;
import generator.Exception.UserExe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler
    public R exceptionHandler(UserExe ex){
        log.error("异常信息：{}", ex.getMessage());
        return R.error(ex.getMessage());
    }
    @ExceptionHandler
    public R exceptionHandler(ScoreExe ex){
        log.error("异常信息：{}", ex.getMessage());
        return R.error(ex.getMessage());
    }




}
