package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Repair;
import com.example.app.domain.RepairFormItem;

@Controller
@RequestMapping("/repair")
public class RepairFormController {
	
	@GetMapping
	public String repairGet(Model model) {
		//var repairFormItem = new RepairFormItem();
		model.addAttribute("repairList", getRepairList());
		return "repair";
		
	}
	
	@PostMapping
	public String repairPost(
		RepairFormItem repairFormItem,
		Model model){
			if(!repairFormItem.getAgreement()) {
				model.addAttribute("repairList",getRepairList());
				return "repair";
			}
			return "repairDone";			
		}
	
	private List<Repair>getRepairList(){
		List<Repair>repairList = new ArrayList<>();
		repairList.add(new Repair(1,"つなげる","ヤスリ有"));
		repairList.add(new Repair(2,"つなげる","ヤスリ無"));
		repairList.add(new Repair(3,"作る","火薬投入"));
		repairList.add(new Repair(4,"不可能","廃棄"));
		return repairList;
	}

}
