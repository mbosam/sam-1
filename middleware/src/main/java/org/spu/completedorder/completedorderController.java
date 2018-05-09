package org.spu.completedorder;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/spu-sam_cards_creation/completedOrder")

public class completedorderController {
	@Autowired
	completedorderDAO completedOrderDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllcompletedOrders")
	public List<completedorderBean> fetchAllcompletedOrders() throws SQLException {

		return completedOrderDAO.fetchAllcompletedOrders();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createcompletedOrder")
	public List<completedorderBean> createcompletedOrder(@RequestBody completedorderBean completedorderBean) throws SQLException {

		return completedOrderDAO.createcompletedorder(completedorderBean.getCompleted_Id(), completedorderBean.getCompleted_Order_Id(),completedorderBean.getCompleted_Date());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatecompletedOrder")
	public List<completedorderBean> updatecompletedOrder(@RequestBody completedorderBean completedorderBean) throws SQLException {

		return completedOrderDAO.updatecompletedorder(completedorderBean.getCompleted_Id(), completedorderBean.getCompleted_Order_Id(),completedorderBean.getCompleted_Date());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletecompletedOrder")
	public List<completedorderBean> deletecompletedOrder(@RequestParam int completed_Id) throws SQLException {

		return completedOrderDAO.deletecompletedOrder(completed_Id);
	}
}
