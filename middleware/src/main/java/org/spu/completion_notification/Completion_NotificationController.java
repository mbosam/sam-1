package org.spu.completion_notification;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.spu.completion_notification.completion_notificationBean;
import org.spu.completion_notification.Completion_NotificationDAO;

@RestController
@RequestMapping(value = "/spu-sam_cards_creation/Completion_Notification")
public class Completion_NotificationController {
	@Autowired
	Completion_NotificationDAO Completion_NotificationDAO;

	@RequestMapping(method = RequestMethod.GET, value = "/fetchAllCompletion_Notifications")
	public List<completion_notificationBean> fetchAllCompletion_Notifications() throws SQLException {

		return Completion_NotificationDAO.fetchAllCompletion_Notifications();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createCompletion_Notification")
	public List<completion_notificationBean> createCompletion_Notification(@RequestBody completion_notificationBean completion_notificationBean) throws SQLException {

		return Completion_NotificationDAO.createCompletion_Notification(completion_notificationBean.getComp_Not_Id(), completion_notificationBean.getComp_Not_Completed_Id(),completion_notificationBean.getComp_Not_Date(),completion_notificationBean.getComp_Not_Message());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateCompletion_Notification")
	public List<completion_notificationBean> updateCompletion_Notification(@RequestBody completion_notificationBean completion_notificationBean) throws SQLException {

		return Completion_NotificationDAO.updateCompletion_Notification(completion_notificationBean.getComp_Not_Id(), completion_notificationBean.getComp_Not_Completed_Id(),completion_notificationBean.getComp_Not_Date(),completion_notificationBean.getComp_Not_Message());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteCompletion_Notification")
	public List<completion_notificationBean> deleteCompletion_Notification(@RequestParam int Comp_Not_Id) throws SQLException {

		return Completion_NotificationDAO.deleteCompletion_Notification( Comp_Not_Id);
	}
}
