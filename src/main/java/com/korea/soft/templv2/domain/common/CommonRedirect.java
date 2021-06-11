package com.korea.soft.templv2.domain.common;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@NoArgsConstructor
@Component
public class CommonRedirect {

	public void CommonRedirect(Model model, String alertMsg) {
		model.addAttribute("alertMsg", alertMsg);
		model.addAttribute("historyBack", true);
	}
}