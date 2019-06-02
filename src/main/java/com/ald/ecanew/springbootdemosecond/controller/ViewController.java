package com.ald.ecanew.springbootdemosecond.controller;

import com.ald.ecanew.springbootdemosecond.config.domain.PersonConfig;
import com.ald.ecanew.springbootdemosecond.dal.domain.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/view")
public class ViewController {

    @Value("${name}")
    private String name;
    @Autowired
    private PersonConfig personConfig;

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("111");
        return "helloWorld222";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        System.out.printf(name);
        return name;
    }

    @GetMapping("/hello3")
    public String sayHello3() {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        return personConfig.getName();
    }

    @GetMapping("/hello4")
    public String testJsp(ModelMap model,String msg) {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        model.put("msg", msg);
        return "index";
    }

    @GetMapping("/hello5")
    public String testJsp5(ModelMap model,UserDo userDo) {
        System.out.println(personConfig.getName());
        System.out.println(personConfig.getGender());
        model.put("msg", userDo.getMsg());
        return "index";
    }

    @GetMapping("/hello21")
    public String viewTest(Model model) {
        model.addAttribute("msg", "KKKK");
        return "viewTest";
    }

    //使用字符串302跳转,属于客户端发起的跳转
    @GetMapping("/hello22")
    public String viewRedirect() {
        return "redirect:/view/hello4?msg=PPPP";
    }

    //使用ModelAndView302跳转
    @GetMapping("/hello23")
    public ModelAndView viewRedirectModel() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/view/hello4?msg=PPPP");
        return mv;
    }

    //使用字符串302跳转,带Java对象
    @GetMapping("/hello24")
    public String viewRedirect2(RedirectAttributes ra) {
        UserDo userDo = new UserDo();
        userDo.setMsg("KKKKKKKMsg");
        ra.addFlashAttribute("userDo", userDo);
        return "redirect:/view/hello5";
    }
    //使用ModelAndView302跳转，带Java对象
    @GetMapping("/hello25")
    public ModelAndView viewRedirectModel2(RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView();
        UserDo userDo = new UserDo();
        userDo.setMsg("KKKKKKKMsg");
        ra.addFlashAttribute("userDo", userDo);
        mv.setViewName("redirect:/view/hello5");
        return mv;
    }
    //使用字response302跳转
    @GetMapping("/hello26")
    public void viewSendRedirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/view/hello4?msg=PPPP");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用字Forward跳转
    @GetMapping("/hello27")
    public void viewForward(HttpServletRequest request, HttpServletResponse response) {
        try {
            //request.getServletContext().getNamedDispatcher("hello4").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //使用字Forward跳转
    @GetMapping("/hello28")
    public void viewForward2(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/hello4?msg=PPPP").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //使用字Forward跳转
    @GetMapping("/hello29")
    public void viewForward3(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getServletContext().getRequestDispatcher("/view/hello4?msg=PPPP").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}