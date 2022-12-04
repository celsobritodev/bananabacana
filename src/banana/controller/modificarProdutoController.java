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
 * Servlet implementation class modificarProdutoController
 */
@WebServlet("/modificarProduto")
public class modificarProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarProdutoController() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=UTF-8");
		 
		 String apagar = request.getParameter("apagar");
		 String alterar = request.getParameter("alterar");
		 String id = request.getParameter("id");
		 
		 if (apagar!=null && id!=null) {
			 new Produto().excluir(Integer.valueOf(id));
			 request.setAttribute("mensagem","Produto apagado com sucesso!");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
			 dispatcher.forward(request, response);
			 
		 } else if (alterar!=null && id!=null) {
			 Produto produto = new Produto().buscarProdutoPorId(Integer.valueOf(id));
			 request.setAttribute("produto",produto);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("alterarProduto.jsp");
			 dispatcher.forward(request, response);
		 }
		 
	}

}
