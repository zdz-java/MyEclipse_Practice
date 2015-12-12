package com.zdz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanqing.po.Subject;
import com.sanqing.util.Page;
import com.sanqing.util.PageResult;
import com.sanqing.util.PageUtil;
import com.zdz.service.SubjectService;
import com.zdz.service.TeacherService;
@Controller
public class TeacherController {
	private SubjectService subjectService;
	
	public SubjectService getSubjectService() {
		return subjectService;
	}
	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@RequestMapping("/teacherIndex")
	public String index()
	{
		return "teacher/index";
	}
	@RequestMapping(value="/subjectAdd",method=RequestMethod.GET)
	public String preSubjectAdd(Model model)
	{
		model.addAttribute("subjectToAdd", new Subject());
		return "teacher/subjectAdd";
	}
	@RequestMapping(value="/subjectAdd",method=RequestMethod.POST)
	public String subjectAdd(@ModelAttribute("subjectToAdd") Subject subject)
	{
		subjectService.saveSubject(subject);
		return "teacher/subjectAdd";
	}
	@RequestMapping(value="subjectManage",method=RequestMethod.GET)
	public String preSubjectManage(Model model,@RequestParam(required=false,defaultValue="1")int currentPage)
	{
		Page page = PageUtil.createPage(10, subjectService.findSubjectCount(), currentPage);
		PageResult pageResult = subjectService.querySubjectByPage(page);
		model.addAttribute("pageResult", pageResult);
		return "teacher/subjectManage";
	}
	@RequestMapping("/subjectQuery")
	public String subjectQuery()
	{
		return "teacher/subjectQuery";
	}
	@RequestMapping("/subjectLikeQuery")
	public String subjectLikeQuery(@RequestParam String subjectTitle,Model model,@RequestParam(required=false,defaultValue="1")int currentPage)
	{
		Page page = PageUtil.createPage(10, 0, currentPage);
		PageResult pageResult = subjectService.likeQueryBySubjectTitle(subjectTitle, page);
		model.addAttribute("pageResult", pageResult);
		return "teacher/subjectManage";
	}
	@RequestMapping("/subjectParticular")
	public String subjectParticular(@RequestParam int subjectID,Model model)
	{
		Subject subject = subjectService.showSubjectParticular(subjectID);
		model.addAttribute("subject", subject);
		return "teacher/subjectShow";
	}
	@RequestMapping("/subjectUpadateBefore")
	public String subjectUpadate(@RequestParam int subjectID,Model model)
	{
		Subject subject = subjectService.showSubjectParticular(subjectID);
		model.addAttribute("subjectToUpdate", subject);
		return "teacher/subjectUpdate";
	}
	@RequestMapping("/subjectUpdate")
	public String updateSubjectForm(@ModelAttribute("subjectToUpdate")Subject subject)
	{
		subjectService.updateSubject(subject);
		return "redirect:/subjectManage";
	}
	@RequestMapping("/subjectDelete")
	public String subjectDelete(@RequestParam int subjectID)
	{
		subjectService.deleteSubject(subjectID);
		return "redirect:/subjectManage";
	}
}
