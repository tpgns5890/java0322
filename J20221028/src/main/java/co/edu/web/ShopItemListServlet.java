package co.edu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.ShopItem;
@WebServlet("/ShopItemListServlet")
public class ShopItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShopItemListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopItem item1 = new ShopItem("item001", "과테말라 안티구아", 5000, 4000, 4.5, "과테말라 안티구아.jpg");
		ShopItem item2 = new ShopItem("item002", "니카라구아 핸드드립", 5500, 4500, 4.0, "니카라구아 핸드드립.jpg");
		ShopItem item3 = new ShopItem("item003", "브라질산토스", 6000, 5000, 3.5, "브라질산토스.jpg");
		ShopItem item4 = new ShopItem("item004", "에티오피아 예가체프", 5200, 4200, 3.5, "에티오피아 예가체프.jpg");
		ShopItem item5 = new ShopItem("item005", "케냐 오크라톡신", 4900, 4100, 4.0, "케냐 오크라톡신.jpg");
		ShopItem item6 = new ShopItem("item006", "코스타리카 따라주", 5800, 4500, 3.0, "코스타리카 따라주.jpg");
		List<ShopItem> itemList = new ArrayList<ShopItem>();
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		itemList.add(item6);
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(itemList));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
