package org.spu.payment;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/payment")
public class paymentController {

	@Autowired
	paymentDAO paymentDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllpayments")
	public List<paymentBean> fetchAllpayments() throws SQLException {

		return paymentDAO.fetchAllpayments();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createpayment")
	public List<paymentBean> createpayment(@RequestBody paymentBean paymentBean) throws SQLException {

		return paymentDAO.createpayment(paymentBean.getPayment_Id(), paymentBean.getPayment_Order_Id(),paymentBean.getPayment_Amount(),paymentBean.getPayment_Date(),paymentBean.getPayment_Mode());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatepayment")
	public List<paymentBean> updatepayment(@RequestBody paymentBean paymentBean) throws SQLException {

		return paymentDAO.updatepayment(paymentBean.getPayment_Id(), paymentBean.getPayment_Order_Id(),paymentBean.getPayment_Amount(),paymentBean.getPayment_Date(),paymentBean.getPayment_Mode());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletepayment")
	public List<paymentBean> deletepayment(@RequestParam int payment_id) throws SQLException {

		return paymentDAO.deletepayment(payment_id);
	}
}