package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.AttachFacility;
import vn.codegym.case_study.model.Contract;
import vn.codegym.case_study.model.ContractDetail;
import vn.codegym.case_study.service.ContractDetailService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;

    @PostMapping("/create")
    public String create(@RequestParam("contract") Contract contract, @RequestParam("attachFacility") AttachFacility[] attachFacility, @RequestParam("quantity") Integer[] quantity, RedirectAttributes redirectAttributes) {
        List<Integer> integerList = new ArrayList<>();

        for (Integer i : quantity) {
            if (i != 0) {
                integerList.add(i);
            }
        }

        quantity = integerList.toArray(new Integer[0]);

        for (int i = 0; i < attachFacility.length; i++) {
            contractDetailService.save(new ContractDetail(contract, attachFacility[i], quantity[i]));
        }

        redirectAttributes.addFlashAttribute("message", "Thêm mới dịch vụ đi kèm thành công!");
        return "redirect:/contract";
    }

}
