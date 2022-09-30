package cs.matemaster.global;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author matemaster
 */
@ControllerAdvice
public class ResponseControllerAdviceImpl implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        GetMapping get = methodParameter.getMethodAnnotation(GetMapping.class);
        PostMapping post = methodParameter.getMethodAnnotation(PostMapping.class);
        PutMapping put = methodParameter.getMethodAnnotation(PutMapping.class);
        DeleteMapping delete = methodParameter.getMethodAnnotation(DeleteMapping.class);

        String[] methods = new String[0];
        if (get != null) {
            methods = get.value();
        }
        if (post != null) {
            methods = post.value();
        }
        if (put != null) {
            methods = put.value();
        }
        if (delete != null) {
            methods = delete.value();
        }

        return ArrayUtil.isNotEmpty(methods);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new SuccessTip(data);
    }
}
