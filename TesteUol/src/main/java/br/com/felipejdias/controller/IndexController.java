package br.com.felipejdias.controller;

import java.util.ArrayList;
import java.util.List;

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

import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.service.CodinomeService;
import br.com.felipejdias.service.JogadoresService;

@Controller
public class IndexController {
	
	@Autowired
	private CodinomeService codinomeService;
	
	@Autowired
	private JogadoresService jogadoresService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		List<JogadoresEntity> jogadores = new ArrayList<JogadoresEntity>();
		
		ModelAndView view = new ModelAndView("index"); 
		jogadores.addAll(jogadoresService.buscarTodos());
		view.addObject("jogadores", jogadores);
		return view;
	}
	
	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrar(JogadoresEntity jogadores) {
		
		ModelAndView view = new ModelAndView("cadastrarJogadores"); 
		view.addObject("jogadores", jogadores);
		view.addObject("codinomes", codinomeService.buscarTodos());		
		return view;
	}
	
	@GetMapping("/cadastrarJogadores")
	public ModelAndView cadastrar(ModelAndView mv, JogadoresEntity jogadores) {
		mv.addObject("jogadores", jogadores);
		mv.addObject("codinomes", codinomeService.buscarTodos());		
		return mv;
	}
	

    @GetMapping("/editar/{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Long id) {
        return cadastrar(jogadoresService.buscarPorId(id));
    }
     
    @GetMapping("/deletar/{codigo}")
    public ModelAndView deletar(@PathVariable("codigo") Long id) {
    	jogadoresService.deletar(id);
        return index();
    }
	
    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid JogadoresEntity jogador, BindingResult result) {

        if(result.hasErrors()) {
            return cadastrar(jogador);
        }else {
        	boolean codinomeDisponivel = jogadoresService.verificaCodinomeDisponivel(jogador.getCdCodinome().getCdCodinome());
        	if(codinomeDisponivel) {
        		 jogadoresService.salvar(jogador);
        		 return index();
        	}else {
        		ModelAndView mv = new ModelAndView("cadastrarJogadores");
        		mv.addObject("message", "Codinome indisponível. Por favor escolha outro.");
        		return cadastrar(mv, jogador);
        	}
        		
        }
              
        
    }

}