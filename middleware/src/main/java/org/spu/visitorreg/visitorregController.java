package org.spu.visitorreg;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.visitorreg.visitorregBean;
import org.spu.visitorreg.visitorregDAO;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/visitorregs")
public class visitorregController {
	@Autowired
	visitorregDAO visitorregDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllvisitorregs")
	public List<visitorregBean> fetchAllvisitorregs() throws SQLException {

		return visitorregDAO.fetchAllvisitorregs();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createvisitorregs")
	public List<visitorregBean> createvisitorreg(@RequestBody visitorregBean visitorregBean) throws SQLException {

		return visitorregDAO.createvisitorregs(visitorregBean.getVisitorreg_Id(),visitorregBean.getVisitorreg_Name(), visitorregBean.getVisitorreg_Contact(),visitorregBean.getVisitorreg_Date(),visitorregBean.getVisitorreg_Email());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatevisitorregs")
	public List<visitorregBean> updatevisitorreg(@RequestBody visitorregBean visitorregBean) throws Exception {

		return visitorregDAO.updatevisitorregs(visitorregBean.getVisitorreg_Id(),visitorregBean.getVisitorreg_Name(), visitorregBean.getVisitorreg_Contact(),visitorregBean.getVisitorreg_Date(),visitorregBean.getVisitorreg_Email());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deletevisitorregs")
	public List<visitorregBean> deletevisitorreg(@RequestParam int getvisitorreg_Id) throws SQLException {

		return visitorregDAO.deletevisitorregs(getvisitorreg_Id);
	}

}
