package org.spu.login;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/login")
public class loginController {

	@Autowired
	loginDAO loginDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAlllogins")
	public List<loginBean> fetchAlllogin() throws SQLException {

		return loginDAO.fetchAlllogins();
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/createlogin")
	public List<loginBean> createlogin(@RequestBody loginBean loginBean) throws SQLException {

		return loginDAO.createlogin(loginBean.getLogin_Id(), loginBean.getLogin_Username(),loginBean.getLogin_Password(),loginBean.getLogin_Rank());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatelogin")
	public List<loginBean> updatelogin(@RequestBody loginBean loginBean) throws SQLException {

		return loginDAO.updatelogin(loginBean.getLogin_Id(), loginBean.getLogin_Username(),loginBean.getLogin_Password(),loginBean.getLogin_Rank());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletelogin")
	public List<loginBean> deletelogin(@RequestParam BigDecimal login_Id) throws SQLException {

		return loginDAO.deletelogin(login_Id);
	}

}
