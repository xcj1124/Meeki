package xaau.xcj.Curriculum.resource.management;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: Meeki
 * @data: 2019/3/12 10:55
 * @message:全局异常
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> resultError() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errorcode", "500");
        map.put("errorMessage", "服务器内部错误");
        return map;
    }
}
