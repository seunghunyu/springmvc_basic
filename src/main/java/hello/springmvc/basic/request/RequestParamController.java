package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt("age");
        log.info("username = {}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("memberName = {}, memberAge={}",memberName,memberAge);
        return "ok";
    }
    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String memberName,
            @RequestParam int memberAge) {

        log.info("memberName = {}, memberAge={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-v4")   //String,int,integer 등의 단순타입이면 RequestParam 생략가능하다
    public String requestParamV4(String memberName, int memberAge) {
        log.info("memberName = {}, memberAge={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-required")
    public String requestParamRequired(   //required 속성은 default 값이 true
            @RequestParam(required = true) String memberName,
            @RequestParam(required = false) int memberAge) {
        log.info("memberName = {}, memberAge={}",memberName,memberAge);
        return "ok";
    }
    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String memberName,
            @RequestParam(required = false, defaultValue = "-1") int memberAge) {
        log.info("memberName = {}, memberAge={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody  //RestController 역할 응답메시지에 ok 넣어줌
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("memberName = {}, memberAge={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        //HelloData helloData = new HelloData();
        //helloData.setUsername(username);
        //helloData.setAge(age);

        log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
        log.info("helloData={}",helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")     //modelAttribute 생략가능
    public String modelAttributeV2(HelloData helloData){
        log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
        log.info("helloData={}",helloData);
        return "ok";
    }
}
