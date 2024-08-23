package guestbook.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import guestbook.entity.Guestbook;

public class GuestbookDao {
	// Guestbook 處存資料集合
	private static List<Guestbook> guestbooks = new CopyOnWriteArrayList<>();

	// 新增 Guestbook
	public void addGuestbook(Guestbook guestbook) {
		guestbooks.add(guestbook);
	}

	// 查詢全部 Guestbook
	public List<Guestbook> findAllGuestbooks() {
		return guestbooks;
	}
}
