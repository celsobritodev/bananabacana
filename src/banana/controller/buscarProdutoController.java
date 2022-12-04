package banana.controller;

import java.io.IOException;
import java.util.ArrayList;

import banana.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class buscarProdutoController
 */
@WebServlet("/buscarProdutos")
public class buscarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buscarProdutoController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("text/html; charset=UTF-8");
	   String descricao = request.getParameter("descricao");
	   ArrayList<Produto> produtos = new Produto().buscarProdutosPorDescricao(descricao);
	   
	   request.setAttribute("produtos", produtos);
	   RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
	   dispatcher.forward(request, response);
	   
	}

}
