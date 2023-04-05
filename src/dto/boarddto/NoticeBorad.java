package dto.boarddto;

public class NoticeBorad extends BoardDTO {
	  public NoticeBorad(int boardNo, String title, String content, String writer, int uuid, String subject, String tag, int likeCnt, int viewCnt, String boardDate) {
	        super(boardNo, title, content, writer, uuid, subject, tag, likeCnt, viewCnt, boardDate);
	    }
}
