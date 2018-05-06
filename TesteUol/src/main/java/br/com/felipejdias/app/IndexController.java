package br.com.felipejdias.app;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.felipejdias.domain.CodinomesEntity;
import br.com.felipejdias.domain.JogadoresEntity;
import br.com.felipejdias.service.CodinomeService;
import br.com.felipejdias.service.JogadoresService;

@Controller
public class IndexController {
	
	@Autowired
	private CodinomeService codinomeService;
	
	@Autowired
	private JogadoresService jogadoresService;

	@GetMapping("/")
	public ModelAndView index() {
		List<JogadoresEntity> jogadores = new ArrayList<JogadoresEntity>();
		
		ModelAndView view = new ModelAndView("/index"); 
		jogadores.addAll(jogadoresService.buscarTodos());
		view.addObject("jogadores", jogadores);
		return view;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(JogadoresEntity jogadores) {
		List<CodinomesEntity> codinomes = new ArrayList<CodinomesEntity>();
		ModelAndView view = new ModelAndView("/cadastrarJogadores"); 
		
		codinomes.addAll(codinomeService.buscarTodos());

		view.addObject("codinomes", codinomes);
		view.addObject("jogadores", jogadores);
		return view;
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
        }
         
        jogadoresService.salvar(jogador);
     
        return index();
    }

}