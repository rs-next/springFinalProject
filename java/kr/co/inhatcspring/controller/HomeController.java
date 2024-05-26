package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.inhatcspring.beans.freeBoardVO;
import kr.co.inhatcspring.database.MapperInterface;

@Controller
public class HomeController {
	
	@Autowired
	MapperInterface board_mapper;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	
	
	@RequestMapping(value = "/writeBoard")
	public String writeFreeBoard(@RequestParam("boardCategory") String boardCategory, Model model) {
	    model.addAttribute("boardCategory", boardCategory);
	    return "writeBoard";
	}

	@RequestMapping(value ="/board",method= RequestMethod.POST)
	public String freeBoard(Model model,@RequestParam("boardCategory") String boardCategory) {		
		List<freeBoardVO> list = board_mapper.search_board(boardCategory); 
		model.addAttribute("list",list);	
		model.addAttribute("boardCategory", boardCategory);
		return "board";
	}
	
	@RequestMapping(value ="/viewBoard")
	public String viewBoard(Model model,@RequestParam("boardID") int boardID) {		
		freeBoardVO view = board_mapper.view_board(boardID); 
		model.addAttribute("view",view);			
		return "viewBoard";
	}
	
	@RequestMapping(value = "/reBoard", method = RequestMethod.POST)
	public String writeActionBoard(freeBoardVO freeBoardVO, Model model) {
	    board_mapper.write_board(freeBoardVO);
	    List<freeBoardVO> list = board_mapper.search_board(freeBoardVO.getBoardCategory());
	    model.addAttribute("list",list);
	    System.out.println("성공");
	    return "board";
	}
	
	@RequestMapping(value = "/actionEdit", method = RequestMethod.POST)
	public String ActionEditBoard(freeBoardVO freeBoardVO, Model model) {
	    board_mapper.update_board(freeBoardVO);
	    System.out.println(freeBoardVO.getBoardID());
	    System.out.println(freeBoardVO.getTitle());
	    System.out.println(freeBoardVO.getBoardContent());
	    freeBoardVO view = board_mapper.view_board(freeBoardVO.getBoardID()); 
	    model.addAttribute("view",view);
	    System.out.println("수정성공");
	    return "viewBoard";
	}
	
	@RequestMapping(value = "/editBoard", method = RequestMethod.POST)
	public String editBoard(@RequestParam("boardID") int boardID, Model model) {	    
	    freeBoardVO view = board_mapper.view_board(boardID);
	    System.out.println(boardID);
	    model.addAttribute("view",view);	    
	    return "editBoard";
	}
	
	@RequestMapping(value = "/deleteBoard", method= RequestMethod.POST)
	public String deleteBoard(Model model, @RequestParam("boardID") int boardID, @RequestParam("boardCategory") String boardCategory) {
		board_mapper.delete_board(boardID);
		List<freeBoardVO> list = board_mapper.search_board(boardCategory);
	    model.addAttribute("list",list);
	    model.addAttribute("boardCategory", boardCategory);
		return "board";
	}
	
	

}

