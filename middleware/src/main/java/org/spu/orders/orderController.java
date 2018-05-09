package org.spu.orders;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.orders.orderBean;
import org.spu.orders.orderDAO;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/order")
public class orderController {
	@Autowired
	orderDAO orderDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllorders")
	public List<orderBean> fetchAllorders() throws SQLException {

		return orderDAO.fetchAllorders();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createorder")
	public List<orderBean> createorder(@RequestBody orderBean orderBean) throws SQLException {

		return orderDAO.createorders(orderBean.getOrder_Id(),orderBean.getOrder_VisitorReg_Id(), orderBean.getOrder_Card_Design_Id(),orderBean.getOrder_Date(),orderBean.getOrder_Id());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateorder")
	public List<orderBean> updateorder(@RequestBody orderBean orderBean) throws SQLException {

		return orderDAO.updateorders(orderBean.getOrder_Id(),orderBean.getOrder_VisitorReg_Id(), orderBean.getOrder_Card_Design_Id(),orderBean.getOrder_Date(),orderBean.getOrder_Id());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteorder")
	public List<orderBean> deleteorder(@RequestParam int order_Id) throws SQLException {

		return orderDAO.deleteorders(order_Id);
	}
}
