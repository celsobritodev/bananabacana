package banana.controller;

import java.io.IOException;

import banana.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastrarProdutoController
 */
@WebServlet("/cadastrarProduto")
public class cadastrarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public cadastrarProdutoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("RECEBI O PEDIDO DE GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String descricao = request.getParameter("descricao");
		
		String mensagem;
		
		if (descricao != null && !descricao.isEmpty() && request.getParameter("quantidade") != null
				&& !request.getParameter("quantidade").isEmpty() && request.getParameter("preco") != null
				&& !request.getParameter("preco").isEmpty()) {
			
			int quantidade;
			double preco;
			quantidade = Integer.parseInt(request.getParameter("quantidade"));

			preco = Double.parseDouble(request.getParameter("preco"));

			boolean online = (request.getParameter("online") != null) && (request.getParameter("online").equals("on"));

			Produto produto = new Produto(descricao,quantidade,preco,online);
		
			produto.salvar();
			
			mensagem = "Produto cadastrado com sucesso";

		} else {

			mensagem = "Os campos precisam ser preenchidos";
		}

		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
		dispatcher.forward(request, response);

	}

}
