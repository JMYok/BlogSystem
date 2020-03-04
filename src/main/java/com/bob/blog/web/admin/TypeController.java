package com.bob.blog.web.admin;

import com.bob.blog.entity.Type;
import com.bob.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/1 21:16
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String list(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * @name 新增分类
     * @param type
     * @param result //必须在紧挨着type，否则校验失效
     * @param attributes
     * @return
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            result.rejectValue("name","nameError","分类名称不能重复");
        }
        if(result.hasErrors()){
            return "admin/types-input";
        }
        Type t = typeService.saveType(type);
        if(t == null){
            attributes.addFlashAttribute("message","操作失败");
        }else{
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            result.rejectValue("name","nameError","分类名称不能重复");
        }
        if(result.hasErrors()){
            return "admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if(t == null){
            attributes.addFlashAttribute("message","操作失败");
        }else{
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @GetMapping("types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","操作成功");
        return "redirect:/admin/types";
    }
}
