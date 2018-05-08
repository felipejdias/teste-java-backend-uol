package br.com.felipejdias.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.felipejdias.domain.CodinomesDisponiveis;
import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.domain.TipoArquivo;
import br.com.felipejdias.service.JogadoresService;

/**
 * 
 * Classe Controller da camada de apresentação contendo os métodos responsáveis por receber uma requisição GET
 * trata-las e atribuir valores na {@link ModelAndView}.
 * 
 * @author Felipe Jaconis
 * 
 */
@Controller
public class IndexController {
	
	@Autowired
	private JogadoresService jogadoresService;

	/**
	 * Método chamado que expõe a URL raiz da aplicação e devolve um {@link ModelAndView} contendo as informações dos jogadores {@link JogadoresEntity}
	 * a serem exibidos em uma tabela HTML. 
	 * 
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		List<JogadoresEntity> jogadores = new ArrayList<JogadoresEntity>();
		
		ModelAndView view = new ModelAndView("index"); 
		jogadores.addAll(jogadoresService.buscarTodos());
		view.addObject("jogadores", jogadores);
		return view;
	}
	
	/**
	 * Método chamado que expõe a URL /cadastrar da aplicação e devolve um {@link ModelAndView} contendo a página HTML com um formulário
	 * para inserção das informações do {@link JogadoresEntity} a serem cadastrados.
	 *  
	 * @param @{ling JogadoresEntity} 
	 * @return {@link ModelAndView}
	 */	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrar(JogadoresEntity jogadores) {
		
		ModelAndView view = new ModelAndView("cadastrarJogadores"); 
		view.addObject("jogadores", jogadores);
		view.addObject("tipoArquivos", TipoArquivo.values());		
		return view;
	}
	
	/**
	 * Método chamado que expõe a URL /cadastrarJogadores necessário ao validar a edição/cadastro de um {@link JogadoresEntity}.  
	 * 
	 * @param @{ling ModelAndView}  Model utilizada na edição 
	 * @param @{ling JogadoresEntity} 
	 * @return {@link ModelAndView}
	 */	
	@GetMapping("/cadastrarJogadores")
	public ModelAndView cadastrar(ModelAndView mv, JogadoresEntity jogadores) {
		mv.addObject("jogadores", jogadores);
		mv.addObject("tipoArquivos", TipoArquivo.values());		
		return mv;
	}
	
	/**
	 * Método chamado que expõe a URL /editar/codigo utilizado para editar um {@link JogadoresEntity}.  
	 * 
	 * @param Codigo do jogador a ser editado 
	 * @return {@link ModelAndView} Tela de edição de jogador contendo os dados do mesmo.
	 */	
    @GetMapping("/editar/{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Long id) {
        return cadastrar(jogadoresService.buscarPorId(id));
    }
    
	/**
	 * Método chamado que expõe a URL /deletar/codigo exclui um registro de {@link JogadoresEntity} da base de dados.  
	 * 
	 * @param Codigo do jogador a ser editado 
	 * @return {@link ModelAndView} Tela de edição de jogador contendo os dados do mesmo.
	 */	
    @GetMapping("/deletar/{codigo}")
    public ModelAndView deletar(@PathVariable("codigo") Long id) {
    	jogadoresService.deletar(id);
        return index();
    }
    
	/**
	 * Método chamado que expõe a URL /salvar salva um  novo registro de {@link JogadoresEntity} da base de dados. 
	 * 
	 * Ao salvar a é feito a validação para saber qual o grupo de herois escolhido e gerar um codinome disponível, caso não haja nenhum,
	 * será retornado mensagem ao usuário.
	 * 
	 * Também é feita a validação para verificar se todos os campos foram preenchidos corretamente antes de salvar.
	 * 
	 * @param {@link JogadoresEntity} Campos realizados a entidade jogador preenchidos
	 * @param {@link BindingResult} Objeto responsável pela trativa dos campos inválidos
	 * @return {@link ModelAndView} Tela de edição de jogador contendo os dados do mesmo.
	 */		
    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid JogadoresEntity jogador, BindingResult result) {

        if(result.hasErrors()) {
            return cadastrar(jogador);
        }else {
        	List<CodinomesDisponiveis> codinomesDisponiveis = jogadoresService.verificaCodinomeDisponivel(jogador.getArquivoSelecionado());
        	if(!codinomesDisponiveis.isEmpty()) {
        		jogador.setCdCodinome(preencheCodinome(codinomesDisponiveis));
        		 jogadoresService.salvar(jogador);
        		 return index();
        	}else {
        		ModelAndView mv = new ModelAndView("cadastrarJogadores");
        		mv.addObject("message", "Codinome indisponível. Por favor escolha outro.");
        		return cadastrar(mv, jogador);
        	}
        		
        }
        
    }
    
	/**
	 * Método responsável por gerar um condinome aleatório com base na lista de codinomes disponíveis.
	 * 
	 *  
	 * @param List<{@link CodinomesEntity}> Codinomes disponíveis
	 * @return {@link CodinomesEntity} Codinome gerado.
	 */		
    
    public CodinomesEntity preencheCodinome(List<CodinomesDisponiveis> codinomesDisponiveis) {
    	Random randomGenerator = new Random();
    	
    	int index = randomGenerator.nextInt(codinomesDisponiveis.size());  
    	
    	CodinomesEntity codinome = new CodinomesEntity();
    	codinome.setCdCodinome(codinomesDisponiveis.get(index).getCdCodinome());
    	codinome.setCdGrupo(codinomesDisponiveis.get(index).getCdGrupo());
    	codinome.setNmCodinome(codinomesDisponiveis.get(index).getNmCodinome());
    	
    	return codinome;
    }
    
    
 
}