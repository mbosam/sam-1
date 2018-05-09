package org.spu.card_design;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.card_design.card_DesignBean;
import org.spu.card_design.card_DesignDAO;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/card_design")
public class card_DesignController {
	@Autowired
	card_DesignDAO card_DesignDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllcard_designs")
	public List<card_DesignBean> fetchAllcard_Designs() throws SQLException {

		return card_DesignDAO.fetchAllcard_Designs();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createcard_design")
	public List<card_DesignBean> createcard_Design(@RequestBody card_DesignBean card_DesignBean) throws SQLException {

		return card_DesignDAO.createcard_Design(card_DesignBean.getCard_Design_Id(),card_DesignBean.getCard_Design_Type(), card_DesignBean.getCard_Design_Color(),card_DesignBean.getCard_Design_Desc());
	}
	@RequestMapping(method = RequestMethod.POST, value = "/updatecard_design")
	public List<card_DesignBean> updatecard_Design(@RequestBody card_DesignBean card_DesignBean) throws SQLException {

		return card_DesignDAO.updatecard_Design(card_DesignBean.getCard_Design_Id(),card_DesignBean.getCard_Design_Type(), card_DesignBean.getCard_Design_Color(),card_DesignBean.getCard_Design_Desc());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletecard_design")
	public List<card_DesignBean> deletecard_Design(@RequestParam  int card_Design_Id) throws SQLException {

		return card_DesignDAO.deletecard_Design(card_Design_Id);
	}

}
