package guestbook.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import guestbook.dao.GuestbookDao;
import guestbook.entity.Guestbook;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guestbook/find")
public class FindGuestbooksServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查詢所有留言紀錄
		GuestbookDao dao = new GuestbookDao();		
		List<Guestbook> guestbooks = dao.findAllGuestbooks();
		
		//將所有留言轉成 jason 格式後印出
		Gson gson = new Gson();
		String guestBooksJasonString = gson.toJson(guestbooks.toArray());
		System.out.println(guestBooksJasonString);
		
		//請 jsp 來協駔資料以 Html 來呈現
		//RequestDispatcher 請求分派器 (後續的工作要誰來接手)
		RequestDispatcher rd = req.getRequestDispatcher("/form/guestbook_find.jsp");
		//準備好要傳送的資料
		req.setAttribute("guestBooks", guestbooks);
		//傳送
		rd.forward(req, resp);
	}
	
	

}
