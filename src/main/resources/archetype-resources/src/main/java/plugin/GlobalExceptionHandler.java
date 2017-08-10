package ${package}.plugin;

import com.google.common.collect.Maps;
import ${package}.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author trang
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        printStackTrace(request, e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    /**
     * 打印异常信息
     */
    private void printErrorMsg(Throwable e) {
        log.error("handle:{}, msg:{}", e.getClass().getName(), e.getMessage());
    }

    /**
     * 打印异常信息和入参
     */
    private void printErrorMsg(HttpServletRequest request, Throwable e) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, Object> map = Maps.transformValues(
                params, arr -> arr.length == 0 ? null : arr.length == 1 ? arr[0] : arr
        );
        log.error("handle:{}, msg:{}, params:{}", e.getClass().getName(), e.getMessage(), JsonUtils.toJson(map));
    }

    /**
     * 打印堆栈和入参
     */
    private void printStackTrace(HttpServletRequest request, Throwable e) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, Object> map = Maps.transformValues(
                params, arr -> arr.length == 0 ? null : arr.length == 1 ? arr[0] : arr
        );
        log.error("handle:{}, params:{}", e.getClass().getName(), JsonUtils.toJson(map), e);
    }

}