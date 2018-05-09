package org.spu.paymentnotification;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.paymentnotification.paymentnotificationBean;
import org.spu.paymentnotification.paymentnotificationDAO;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/paymentnotification")
public class paymentnotificationController {
	@Autowired
	paymentnotificationDAO paymentnotificationDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllpaymentnotification")
	public List<paymentnotificationBean> fetchAllpaymentnotifications() throws SQLException {

		return paymentnotificationDAO.fetchAllpaymentnotifications();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createpaymentnotification")
	public List<paymentnotificationBean> createpaymentnotification(@RequestBody paymentnotificationBean paymentnotificationBean) throws SQLException {

		return paymentnotificationDAO.createpaymentnotification(paymentnotificationBean.getPaymentnotification_Id(), paymentnotificationBean.getPaymentnotification_Completed_Id(),paymentnotificationBean.getPaymentnotification_Date(),paymentnotificationBean.getPaymentnotification_Message());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatepaymentnotification")
	public List<paymentnotificationBean> updatepaymentnotifications(@RequestBody paymentnotificationBean paymentnotificationBean) throws SQLException {

		return paymentnotificationDAO.updatepaymentnotification(paymentnotificationBean.getPaymentnotification_Id(), paymentnotificationBean.getPaymentnotification_Completed_Id(),paymentnotificationBean.getPaymentnotification_Date(),paymentnotificationBean.getPaymentnotification_Message());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletepaymentnotification")
	public List<paymentnotificationBean> deletepaymentnotification(@RequestParam  int paymentnotification_Id) throws SQLException {

		return paymentnotificationDAO.deletepaymentnotification( paymentnotification_Id);
	}
}
