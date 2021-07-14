package hello.sevlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String,String> paramMap, Map<String,Object> model);
    //모델 객체 전달하는 부분 추가
}
