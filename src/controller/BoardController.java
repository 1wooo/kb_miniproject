package controller;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
import service.BoardService;
import service.BoardServiceImpl;
import view.FailView;
import view.SuccessView;

public class BoardController {
    private static BoardService boardService = BoardServiceImpl.getInstance();

    public static void boardSelectAll() {
        try {
        	List<BoardDTO> boardList = boardService.boardSelectAll();
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
     
    public static void boardSelectByUserId(int uuid) {
    	try {
    		List<BoardDTO> boardList = boardService.boardSelectByUserId(uuid);
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    public static void boardSelectBySubject(String subject) {
        try {
        	List<BoardDTO> boardList = boardService.boardSelectBySubject(subject);
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    public static void boardSelectByKeyword(String target, String keyWord) {
    	try {
        	List<BoardDTO> boardList = boardService.boardSelectByKeyword(target, keyWord);
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    public static void boardSelectByLike() {
    	try {
        	List<BoardDTO> boardList = boardService.boardSelectByLike();
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
   
    public static void boardSelectByView() {
    	try {
        	List<BoardDTO> boardList = boardService.boardSelectByView();
        	SuccessView.boardListPrint(boardList, 1);
        } catch (SearchWrongException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    public static void boardInsert(BoardDTO boardDTO) {
    	try {
        	boardService.boardInsert(boardDTO);
        	SuccessView.messagePrint("게시글을 작성했습니다.");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
    public static void boardUpdate(BoardDTO boardDTO) {
       	try {
        	boardService.boardUpdate(boardDTO);
        	SuccessView.messagePrint("게시글을 수정했습니다.");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    public static void boardDelete(int boardNo) {
       	try {
        	boardService.boardDelete(boardNo);
        	SuccessView.messagePrint("게시글을 삭제했습니다.");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void replyInsert(ReplyDTO replyDTO) {
        try {
            boardService.insertReply(replyDTO);
            SuccessView.messagePrint("댓글을 작성했습니다.");
        } catch (DMLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

}
