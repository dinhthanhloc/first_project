package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DAOkhachhang;
import model.khach_hang;

/**
 * Servlet implementation class KhachhangController
 */
@WebServlet("/khach-hang")
public class KhachhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KhachhangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("save-login")) {
			SaveLogin(request, response);
		} else if (action.equals("save-signup")) {
			SaveSignUp(request, response);
		} else if (action.equals("log-out")) {
			LogOut(request, response);
		} else if (action.equals("save-profile")) {
			SaveProfile(request, response);
		} else if (action.equals("id-shoes")) {
			IdShoes(request, response);
		} else if (action.equals("buy-shoes")) {
			BuyShoes(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void SaveLogin(HttpServletRequest request, HttpServletResponse response) {
		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			khach_hang kh = new khach_hang();
			kh.setEmail(email);
			kh.setPassword(password);

			khach_hang khach_hang = DAOkhachhang.getInstance().selectbyEmailAndPassword(kh);
			String url = "";
			if (khach_hang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khach_hang", khach_hang);
				url = "/index.jsp";
			} else {
				request.setAttribute("errorEmail", "Tên đăng nhập hoặc mật khẩu không đúng!");
				url = "/khachhang/Login.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void SaveSignUp(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String password_again = request.getParameter("password_again");

			// forward value

			request.setAttribute("value_username", username);
			request.setAttribute("value_email", email);

			// check
			String errorEmail = "";
			String errorPassword = "";
			String errorPasswordAgain = "";
			boolean check = false;

			// check error Email
			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email);

			if (!emailMatcher.matches()) {
				check = true;
				errorEmail += "Bạn cần nhập email theo cấu trúc name@examples.vn";
			}

			// check error Password and Password Again
			if (!password.equals(password_again)) {
				check = true;
				errorPasswordAgain += "Password và Password Again không khớp";
			}
			Pattern passwordPattern = Pattern.compile(".{8}.*");
			Matcher passwordMatcher = passwordPattern.matcher(password);

			if (!passwordMatcher.matches()) {
				errorPassword += "Password tối thiểu phải có 8 kí tự";
				check = true;
			}

			// check error data
			khach_hang khach_hang = new khach_hang();
			khach_hang.setEmail(email);

			khach_hang ketqua = DAOkhachhang.getInstance().selectbyEmail(khach_hang);

			if (ketqua != null || check) {
				check = true;
				if (ketqua != null)
					errorEmail = "Email đã được sử dụng";
			} else {
				Random rd = new Random();
				String ma_khach_hang = System.currentTimeMillis() + rd.nextInt(1000) + "";

				khach_hang kq = new khach_hang(ma_khach_hang, username, email, password);

				DAOkhachhang.getInstance().insert_login(kq);
			}

			// forward error

			request.setAttribute("errorEmail", errorEmail);
			request.setAttribute("errorPassword", errorPassword);
			request.setAttribute("errorPasswordAgain", errorPasswordAgain);

			// url
			String url = "/khachhang/Login.jsp";

			if (check) {
				url = "/khachhang/Sign_up.jsp";
			}

			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void LogOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();

			session.invalidate();

			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();

			response.sendRedirect(url + "/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void SaveProfile(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			String username = request.getParameter("username");
			String so_dien_thoai = request.getParameter("so_dien_thoai") + "";
			String gioi_tinh = request.getParameter("gioi_tinh");
			String dia_chi = request.getParameter("dia_chi");
			String dob = request.getParameter("dob") + "";
			String dang_ki = request.getParameter("dang_ki");

			request.setAttribute("username", username);
			request.setAttribute("dia_chi", dia_chi);
			request.setAttribute("so_dien_thoai", so_dien_thoai);
			request.setAttribute("gioi_tinh", gioi_tinh);
			request.setAttribute("dob", dob);

			boolean check = false;

			String errorSdt = "";

			// Error Số điện thoại
			Pattern sdtPattern = Pattern.compile("0\\d{9}\\d*");
			Matcher sdtMatcher = sdtPattern.matcher(so_dien_thoai);

			if (!so_dien_thoai.equals("")) {
				if (!sdtMatcher.matches()) {
					check = true;
					errorSdt = "Bạn nhập sai số điện thoại";
				}
			}

			request.setAttribute("errorSdt", errorSdt);

			if (dob.equals("")) {
				dob = "2000-01-01";
			}

			String url = "/khachhang/Profile.jsp";

			if (!check) {
				Object obj = request.getSession().getAttribute("khach_hang");
				khach_hang khach_hang = null;
				if (obj != null) {
					khach_hang = (khach_hang) obj;
				}
				if (khach_hang != null) {
					String ma_khach_hang = khach_hang.getMa_khach_hang();
					khach_hang ketqua = new khach_hang(ma_khach_hang, username, gioi_tinh, dia_chi, Date.valueOf(dob),
							so_dien_thoai, dang_ki != null);
					DAOkhachhang.getInstance().update_profile(ketqua);

					HttpSession session = request.getSession();
					session.setAttribute("khach_hang", ketqua);

					request.setAttribute("update", "Cập nhập thông tin thành công!");
				}
			}

			RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
			rq.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void IdShoes(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id_shoes = request.getParameter("id-shoes");

			request.setAttribute("id_shoes", id_shoes);

			String url = "/khachhang/Buy_shoes.jsp";

			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void BuyShoes(HttpServletRequest request, HttpServletResponse response) {
		try {
			String option_base = request.getParameter("options-base") + "";
			String id_shoes = request.getParameter("id-shoes");
			String amount = request.getParameter("amount");

			request.setAttribute("id_shoes", id_shoes);
			request.setAttribute("option_base", option_base);
			request.setAttribute("amount", amount);

			String url = "/khachhang/Buy_complete.jsp";

			RequestDispatcher rd = request.getRequestDispatcher(url);

			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
